package services

import (
	"context"
	pb "github.com/eco-heroes/server/proto/helloworld"
	"google.golang.org/grpc"
	"log"
)

type GreeterService struct {
	pb.UnimplementedGreeterServer
}

func (s *GreeterService) SayHello(_ context.Context, req *pb.HelloRequest) (*pb.HelloReply, error) {
	log.Println(req.GetName())
	return &pb.HelloReply{Message: "Hello " + req.GetName()}, nil
}

func (s *GreeterService) Register(server *grpc.Server) {
	pb.RegisterGreeterServer(server, &GreeterService{})
}
