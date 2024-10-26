package main

import "google.golang.org/grpc"

type RegistrableService interface {
	Register(server *grpc.Server)
}
