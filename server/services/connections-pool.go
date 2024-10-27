package services

import (
	pb "github.com/eco-heroes/server/proto/gameevents"
	"google.golang.org/grpc"
	"sync"
)

var lock = sync.Mutex{}

var instance *ConnectionsPool

// ConnectionsPool /* Do not instance manually, use GetConnPoolInstance() instead */
type ConnectionsPool struct {
	connections []Connection
}

type Connection struct {
	playerNumber int
	room         *pb.Room
	stream       grpc.ServerStreamingServer[pb.ServerEvent]
	channel      chan *pb.ServerEvent
}

func (cp *ConnectionsPool) Add(room *pb.Room, stream grpc.ServerStreamingServer[pb.ServerEvent]) *Connection {
	conn := &Connection{
		// TODO: Implement logic to set player numbers.
		playerNumber: 1,
		room:         room,
		stream:       stream,
		channel:      make(chan *pb.ServerEvent),
	}

	cp.connections = append(cp.connections, *conn)

	return conn
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
	if instance == nil {
		lock.Lock()
		defer lock.Unlock()
		if instance == nil {
			instance = &ConnectionsPool{}
		}
	}

	return instance
}
