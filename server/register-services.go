package main

import (
	"github.com/eco-heroes/server/services"
	"google.golang.org/grpc"
)

var registrableServices []RegistrableService = []RegistrableService{
	&services.GreeterService{},
	&services.PingService{},
	&services.GameEventsService{},
}

/*
Register all listed services into a GRPC Server
*/
func registerServices(server *grpc.Server) {
	for _, s := range registrableServices {
		s.Register(server)
	}
}
