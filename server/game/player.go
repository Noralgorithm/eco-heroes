package game

import (
	pb "github.com/eco-heroes/server/proto/gameevents"
	"google.golang.org/grpc"
)

type Player struct {
	Number     int
	Connection Connection
}

type Connection struct {
	Stream  grpc.ServerStreamingServer[pb.ServerEvent]
	Channel chan *pb.ServerEvent
}

func (p *Player) Subscribe(stream grpc.ServerStreamingServer[pb.ServerEvent]) (*Player, error) {
	p.Connection = Connection{
		Stream:  stream,
		Channel: make(chan *pb.ServerEvent),
	}

	return p, nil
}

func (p *Player) Notify(evt *pb.ServerEvent) {
	p.Connection.Channel <- evt
}
