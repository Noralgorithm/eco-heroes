package game

import (
	"fmt"
	pb "github.com/eco-heroes/server/proto/gameevents"
	"github.com/google/uuid"
)

var (
	InitialSpeed = 1
)

type Room struct {
	Id      uuid.UUID
	Matches []Match
	Players []Player
	Speed   int
}

func NewRoom() Room {
	return Room{Id: uuid.New(), Players: []Player{}, Matches: []Match{}, Speed: InitialSpeed}
}

func CreateRoom() *Room {
	newRoom := NewRoom()
	ActiveRooms = append(ActiveRooms, &newRoom)
	return &newRoom
}

// TODO LOGIC TO ASSIGN PLAYER NUMBER
// TODO: add validation for when you want to join a room and you already have the limit of players.
func (r *Room) AddPlayer() *Player {

	newPlayer := Player{
		Number: len(r.Players) + 1,
	}

	r.Players = append(r.Players, newPlayer)

	return &newPlayer
}

func (r *Room) FindPlayer(playerNumber int) *Player {
	fmt.Println(playerNumber)
	fmt.Println(r.Players)

	for _, player := range r.Players {
		if player.Number == playerNumber {
			return &player
		}
	}
	return nil
}

func (r *Room) Notify(evt *pb.ServerEvent) {
	for _, player := range r.Players {
		player.Notify(evt)
	}
}
