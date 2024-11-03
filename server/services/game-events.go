package services

import (
	"context"
	"errors"

	"github.com/eco-heroes/server/game"
	pb "github.com/eco-heroes/server/proto/gameevents"
	"google.golang.org/grpc"
)

type GameEventsService struct {
	pb.UnimplementedGameEventsServer
}

func (*GameEventsService) Subscribe(sr *pb.SubscriptionRequest, stream grpc.ServerStreamingServer[pb.ServerEvent]) error {
	errCh := make(chan error)

	room := game.FindActiveRoom(sr.RoomId)
	if room == nil {
		return errors.New("room not found")
	}

	player, _ := room.FindPlayer(int(sr.PlayerNumber))
	if player == nil {
		return errors.New("player not found")
	}

	go func() {
		room.Notify(&pb.ServerEvent{
			Event: &pb.ServerEvent_PlayerAddedEvt{
				PlayerAddedEvt: &pb.PlayerAdded{
					PlayerNumber: int32(player.Number)}}})
	}()

	connectedPlayer, err := player.Subscribe(stream)

	if err != nil {
		return err
	}

	go listenAndHandleEvents(&connectedPlayer.Connection, errCh)

	return <-errCh
}

func (*GameEventsService) StarGame(_ context.Context, sgr *pb.StartGameRequest) (*pb.RoomGameDataReply, error) {
	room := game.FindActiveRoom(sgr.RoomId)
	if room == nil {
		return nil, errors.New("room not found")
	}

	newGame := game.NewGame(room)

	newGame.Start()
	playersInRoom := make([]*pb.PlayerInRoomGameData, len(room.Players))

	for i, p := range room.Players {
		playersInRoom[i] = &pb.PlayerInRoomGameData{
			Number: int32(p.Number),
		}
	}
	out := &pb.RoomGameDataReply{
		Id:           room.Id.String(),
		Players:      playersInRoom,
		PlayersLimit: int32(playersLimit),
	}
	return out, nil
}

func listenAndHandleEvents(conn *game.Connection, errCh chan error) {
	for {
		event := <-conn.Channel
		err := conn.Stream.Send(event)

		if err != nil {
			errCh <- err
		}
	}
}

func (s *GameEventsService) Register(server *grpc.Server) {
	pb.RegisterGameEventsServer(server, &GameEventsService{})
}
