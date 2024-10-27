package services

import (
	pb "github.com/eco-heroes/server/proto/gameevents"
	"google.golang.org/grpc"
	"strconv"
	"time"
)

type GameEventsService struct {
	pb.UnimplementedGameEventsServer
}

func (s *GameEventsService) Subscribe(room *pb.Room, stream grpc.ServerStreamingServer[pb.ServerEvent]) error {
	err := make(chan error)

	pool := GetConnPoolInstance()

	conn := pool.Add(room, stream)

	go listenAndHandleEvents(conn, err)

	go debugEvents(pool)

	return <-err
}

func debugEvents(cp *ConnectionsPool) {
	i := 0
	for {
		time.Sleep(1000 * time.Millisecond)
		cp.Roomcast("1", &pb.ServerEvent{Type: "Test :3 " + strconv.Itoa(i)})
		i++
	}
}

func listenAndHandleEvents(conn *Connection, errCh chan error) {
	for {
		event := <-conn.channel

		err := conn.stream.Send(event)

		if err != nil {
			errCh <- err
		}
	}
}

func (s *GameEventsService) Register(server *grpc.Server) {
	pb.RegisterGameEventsServer(server, &GameEventsService{})
}
