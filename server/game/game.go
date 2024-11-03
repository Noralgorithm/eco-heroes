package game

import (
	pb "github.com/eco-heroes/server/proto/gameevents"
)

type Game struct {
	room *Room
}

var ActiveRooms []*Room

func FindActiveRoom(roomId string) *Room {
	for _, r := range ActiveRooms {
		if r.Id.String() == roomId {
			return r
		}
	}

	return nil
}

func NewGame(r *Room) Game {
	return Game{room: r}
}

func CreateGame(r *Room) *Game {
	newGame := NewGame(r)
	return &newGame
}

func (g *Game) Execute() {
	go func() {
		g.room.Notify(&pb.ServerEvent{
			Event: &pb.ServerEvent_GameStarted{
				GameStarted: &pb.GameStarted{
					Message: "game started for this room",
				}}})
	}()
}
