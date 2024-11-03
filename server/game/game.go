package game

import (
	pb "github.com/eco-heroes/server/proto/gameevents"
	"log"
	"time"
)

const (
	InitialSpeed = 1
	MaxSpeed     = 6
)

type Game struct {
	Room            *Room
	Speed           int
	GameOverChannel chan bool
	WasteAmountSent int
}

func NewGame(r *Room) Game {
	return Game{Room: r, Speed: InitialSpeed, GameOverChannel: make(chan bool), WasteAmountSent: 0}
}

func (g *Game) Start() {
	g.Room.Notify(&pb.ServerEvent{
		Event: &pb.ServerEvent_GameStartedEvt{
			GameStartedEvt: &pb.GameStarted{
				Message: "game started for this Room",
			}}})

	for _, p := range g.Room.Players {
		p.InitMatch()
	}

	go g.WasteGenerationLoop()
}

func (g *Game) WasteGenerationLoop() {
	interval := time.Second * time.Duration((MaxSpeed-1)-g.Speed)

	for {
		select {
		case <-g.GameOverChannel:
			return
		default:
			time.Sleep(interval)
			g.SendWaste()
		}
	}
}

func (g *Game) SendWaste() {
	waste := GenerateRandomWaste()

	log.Printf("Generated waste: %v", waste) // Agrega un log aquí

	g.Room.Notify(
		&pb.ServerEvent{
			Event: &pb.ServerEvent_WasteGeneratedEvt{WasteGeneratedEvt: &pb.WasteGenerated{Waste: waste}},
		})
	g.WasteAmountSent++
}

func (g *Game) UpdateGameSpeed() {
	if g.Speed >= MaxSpeed {
		return
	}

	if g.WasteAmountSent%10 == 0 {
		g.Speed++
	}
}
