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

func (s *GreeterService) SayHello(_ context.Context, in *pb.HelloRequest) (*pb.HelloReply, error) {
	log.Println(in.GetName())
	return &pb.HelloReply{Message: "Hello " + in.GetName()}, nil
}

func (s *GreeterService) Register(server *grpc.Server) {
	pb.RegisterGreeterServer(server, &GreeterService{})
}
