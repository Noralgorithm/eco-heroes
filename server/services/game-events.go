package services

import (
	"strconv"
	"time"

	pb "github.com/eco-heroes/server/proto/gameevents"
	"google.golang.org/grpc"
)

type GameEventsService struct {
	pb.UnimplementedGameEventsServer
}

func (s *GameEventsService) Subscribe(room *pb.Room, stream grpc.ServerStreamingServer[pb.ServerEvent]) error {
	errCh := make(chan error)

	pool := GetConnPoolInstance()

	conn, err := pool.Add(room.Id, stream)

	if err != nil {
		return err
	}

	go listenAndHandleEvents(conn, errCh)
	go debugEvents(pool)

	return <-errCh
}

func debugEvents(cp *ConnectionsPool) {
	i := 0
	for {
		time.Sleep(1000 * time.Millisecond)
		cp.Roomcast("hola", &pb.ServerEvent{Type: "Test :3 " + strconv.Itoa(i)})
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
