package services

import (
	"errors"
	"slices"
	"sync"

	"github.com/eco-heroes/server/game"
	pb "github.com/eco-heroes/server/proto/gameevents"
	"google.golang.org/grpc"
)

var once = sync.Once{}

var instance *ConnectionsPool

// ConnectionsPool /* Do not instance manually, use GetConnPoolInstance() instead */
type ConnectionsPool struct {
	connections []Connection
	rooms       []game.Room
}

type Connection struct {
	player  game.Player
	room    *game.Room
	stream  grpc.ServerStreamingServer[pb.ServerEvent]
	channel chan *pb.ServerEvent
}

func (cp *ConnectionsPool) Add(roomId string, stream grpc.ServerStreamingServer[pb.ServerEvent]) (*Connection, error) {
	roomIdx := slices.IndexFunc(cp.rooms, func(gr game.Room) bool { return gr.Id == roomId })

	if roomIdx == -1 {
		return nil, errors.New("that room doesn't exists")
	}

	r := cp.rooms[roomIdx]

	p := r.CreateNewPlayer()

	conn := &Connection{
		player:  p,
		room:    &r,
		stream:  stream,
		channel: make(chan *pb.ServerEvent),
	}

	cp.connections = append(cp.connections, *conn)

	return conn, nil
}

func (cp *ConnectionsPool) Roomcast(roomId string, evt *pb.ServerEvent) {
	for _, conn := range cp.connections {
		if conn.room.Id == roomId {
			conn.channel <- evt
			return
		}

	}
}

func (cp *ConnectionsPool) Broadcast(evt *pb.ServerEvent) {
	for _, conn := range cp.connections {
		conn.channel <- evt
	}
}

func GetConnPoolInstance() *ConnectionsPool {
	once.Do(func() {
		instance = &ConnectionsPool{}

		assignDebugRoom(instance)
	})

	return instance
}

func assignDebugRoom(cp *ConnectionsPool) {
	cp.rooms = append(cp.rooms, game.NewRoom())
}
