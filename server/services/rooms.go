package services

import (
	"context"
	"errors"
	"github.com/eco-heroes/server/game"
	pb "github.com/eco-heroes/server/proto/rooms"
	"google.golang.org/grpc"
	"google.golang.org/protobuf/types/known/emptypb"
)

var playersLimit = 4

type RoomsService struct {
	pb.UnimplementedRoomsServer
}

func (rs *RoomsService) CreateAndJoin(context.Context, *emptypb.Empty) (*pb.RoomDataReply, error) {
	room := game.CreateRoom()
	player := room.AddPlayer()

	out := &pb.RoomDataReply{
		Id:           room.Id.String(),
		Players:      []*pb.PlayerInRoomData{{Number: int32(player.Number)}},
		PlayersLimit: int32(playersLimit),
		Me:           &pb.PlayerInRoomData{Number: int32(player.Number)},
	}

	return out, nil
}

func (rs *RoomsService) Join(_ context.Context, jr *pb.JoinRequest) (*pb.RoomDataReply, error) {
	room := game.FindActiveRoom(jr.RoomId)

	if room == nil {
		return nil, errors.New("room not found")
	}

	if len(room.Players) == playersLimit {
		return nil, errors.New("the limit of players has been reached")
	}
	player := room.AddPlayer()

	//TODO ADD FUNCTION TO GET PLAYERS IN A ROOM?

	playersInRoom := make([]*pb.PlayerInRoomData, len(room.Players))

	for i, p := range room.Players {
		playersInRoom[i] = &pb.PlayerInRoomData{
			Number: int32(p.Number),
		}
	}

	out := &pb.RoomDataReply{
		Id:           room.Id.String(),
		Players:      playersInRoom,
		PlayersLimit: int32(playersLimit),
		Me:           &pb.PlayerInRoomData{Number: int32(player.Number)},
	}

	return out, nil

}

func (rs *RoomsService) Fetch(_ context.Context, _ *emptypb.Empty) (*pb.RoomsListReply, error) {
	rooms := game.ActiveRooms
	roomsList := make([]*pb.RoomDataReply, len(rooms))

	for i, r := range rooms {
		playersInRoom := make([]*pb.PlayerInRoomData, len(r.Players))

		for i, p := range r.Players {
			playersInRoom[i] = &pb.PlayerInRoomData{
				Number: int32(p.Number),
			}
		}

		roomsList[i] = &pb.RoomDataReply{
			Id:           r.Id.String(),
			Players:      playersInRoom,
			PlayersLimit: 4,
		}
	}

	out := &pb.RoomsListReply{
		Rooms: roomsList,
	}

	return out, nil
}

func (rs *RoomsService) Register(server *grpc.Server) {
	pb.RegisterRoomsServer(server, &RoomsService{})
}
