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
	for {
		select {
		case <-g.GameOverChannel:
			return
		default:
			interval := time.Second * time.Duration((MaxSpeed+1)-g.Speed)
			time.Sleep(interval)
			g.IsGameOver()
			g.SendWaste()
			g.UpdateGameSpeed()
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

func (g *Game) IsGameOver() {

	var playerWinnerNumber = 0
	var maxLives = 0
	var aliveCount = 0

	for _, player := range g.Room.Players {
		if player.Match.Lives != 0 {
			aliveCount++
			if player.Match.Lives > maxLives {
				maxLives = player.Match.Lives
				playerWinnerNumber = player.Number
			}
		}
	}

	if aliveCount == 1 {
		g.Room.Notify(&pb.ServerEvent{Event: &pb.ServerEvent_GameEndedEvt{GameEndedEvt: &pb.GameEnded{
			WinnerNumber: int32(playerWinnerNumber),
		}}})
		g.GameOverChannel <- true
	}

}
