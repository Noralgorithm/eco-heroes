package services

import (
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

	connectedPlayer, err := player.Subscribe(stream)
	if err != nil {
		return err
	}

	go listenAndHandleEvents(&connectedPlayer.Connection, errCh)
	go func() {
		room.Notify(&pb.ServerEvent{Type: pb.Type_PLAYER_ADDED})
	}()
	//go debugEvents(player)

	return <-errCh
}

/*func debugEvents(player *game.Player) {
	i := 0
	for {
		time.Sleep(1000 * time.Millisecond)
		player.Notify(&pb.ServerEvent{Type: pb.Type_PLAYER_ADDED})
		i++
	}
}*/

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
