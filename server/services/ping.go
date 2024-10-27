package services

import (
	"context"
	pb "github.com/eco-heroes/server/proto/ping"
	"google.golang.org/grpc"
)

type PingService struct {
	pb.UnimplementedPingerServer
}

func (s *PingService) Ping(_ context.Context, in *pb.PingRequest) (*pb.PingReply, error) {
	return &pb.PingReply{Message: "Ping!"}, nil
}

func (s *PingService) Register(server *grpc.Server) {
	pb.RegisterPingerServer(server, &PingService{})
}
