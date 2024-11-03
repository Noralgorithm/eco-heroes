package game

import (
	"errors"

	pb "github.com/eco-heroes/server/proto/gameevents"
	"github.com/google/uuid"
)

type Room struct {
	Id      uuid.UUID
	Matches []Match
	Players []*Player
}

func NewRoom() Room {
	return Room{Id: uuid.New(), Players: []*Player{}, Matches: []Match{}}
}

func CreateRoom() *Room {
	newRoom := NewRoom()
	ActiveRooms = append(ActiveRooms, &newRoom)
	return &newRoom
}

func (r *Room) AddPlayer() *Player {

	newPlayer := Player{
		Number: len(r.Players) + 1,
	}

	r.Players = append(r.Players, &newPlayer)

	return &newPlayer
}

func (r *Room) RemovePlayer(playerNumber int) error {
	player, index := r.FindPlayer(playerNumber)

	if player == nil {
		return errors.New("player not found")
	}

	r.Players = append(r.Players[:index], r.Players[index+1:]...)

	for i := index; i < len(r.Players); i++ {
		r.Players[i].Number = i + 1
	}

	return nil
}

func (r *Room) FindPlayer(playerNumber int) (*Player, int) {

	for i, player := range r.Players {
		if player.Number == playerNumber {
			return player, i
		}
	}
	return nil, 0
}

func (r *Room) Notify(evt *pb.ServerEvent) {
	for _, player := range r.Players {
		go player.Notify(evt)
	}
}
