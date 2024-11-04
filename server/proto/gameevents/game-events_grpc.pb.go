// Code generated by protoc-gen-go-grpc. DO NOT EDIT.
// versions:
// - protoc-gen-go-grpc v1.5.1
// - protoc             v5.28.3
// source: game-events.proto

package gameevents

import (
	context "context"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	emptypb "google.golang.org/protobuf/types/known/emptypb"
)

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
// Requires gRPC-Go v1.64.0 or later.
const _ = grpc.SupportPackageIsVersion9

const (
	GameEvents_Subscribe_FullMethodName    = "/ecoheroes.GameEvents/subscribe"
	GameEvents_StartGame_FullMethodName    = "/ecoheroes.GameEvents/startGame"
	GameEvents_DepositWaste_FullMethodName = "/ecoheroes.GameEvents/depositWaste"
)

// GameEventsClient is the client API for GameEvents service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://pkg.go.dev/google.golang.org/grpc/?tab=doc#ClientConn.NewStream.
type GameEventsClient interface {
	Subscribe(ctx context.Context, in *SubscriptionRequest, opts ...grpc.CallOption) (grpc.ServerStreamingClient[ServerEvent], error)
	StartGame(ctx context.Context, in *StartGameRequest, opts ...grpc.CallOption) (*RoomGameDataReply, error)
	DepositWaste(ctx context.Context, in *DepositWasteRequest, opts ...grpc.CallOption) (*emptypb.Empty, error)
}

type gameEventsClient struct {
	cc grpc.ClientConnInterface
}

func NewGameEventsClient(cc grpc.ClientConnInterface) GameEventsClient {
	return &gameEventsClient{cc}
}

func (c *gameEventsClient) Subscribe(ctx context.Context, in *SubscriptionRequest, opts ...grpc.CallOption) (grpc.ServerStreamingClient[ServerEvent], error) {
	cOpts := append([]grpc.CallOption{grpc.StaticMethod()}, opts...)
	stream, err := c.cc.NewStream(ctx, &GameEvents_ServiceDesc.Streams[0], GameEvents_Subscribe_FullMethodName, cOpts...)
	if err != nil {
		return nil, err
	}
	x := &grpc.GenericClientStream[SubscriptionRequest, ServerEvent]{ClientStream: stream}
	if err := x.ClientStream.SendMsg(in); err != nil {
		return nil, err
	}
	if err := x.ClientStream.CloseSend(); err != nil {
		return nil, err
	}
	return x, nil
}

// This type alias is provided for backwards compatibility with existing code that references the prior non-generic stream type by name.
type GameEvents_SubscribeClient = grpc.ServerStreamingClient[ServerEvent]

func (c *gameEventsClient) StartGame(ctx context.Context, in *StartGameRequest, opts ...grpc.CallOption) (*RoomGameDataReply, error) {
	cOpts := append([]grpc.CallOption{grpc.StaticMethod()}, opts...)
	out := new(RoomGameDataReply)
	err := c.cc.Invoke(ctx, GameEvents_StartGame_FullMethodName, in, out, cOpts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *gameEventsClient) DepositWaste(ctx context.Context, in *DepositWasteRequest, opts ...grpc.CallOption) (*emptypb.Empty, error) {
	cOpts := append([]grpc.CallOption{grpc.StaticMethod()}, opts...)
	out := new(emptypb.Empty)
	err := c.cc.Invoke(ctx, GameEvents_DepositWaste_FullMethodName, in, out, cOpts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// GameEventsServer is the server API for GameEvents service.
// All implementations must embed UnimplementedGameEventsServer
// for forward compatibility.
type GameEventsServer interface {
	Subscribe(*SubscriptionRequest, grpc.ServerStreamingServer[ServerEvent]) error
	StartGame(context.Context, *StartGameRequest) (*RoomGameDataReply, error)
	DepositWaste(context.Context, *DepositWasteRequest) (*emptypb.Empty, error)
	mustEmbedUnimplementedGameEventsServer()
}

// UnimplementedGameEventsServer must be embedded to have
// forward compatible implementations.
//
// NOTE: this should be embedded by value instead of pointer to avoid a nil
// pointer dereference when methods are called.
type UnimplementedGameEventsServer struct{}

func (UnimplementedGameEventsServer) Subscribe(*SubscriptionRequest, grpc.ServerStreamingServer[ServerEvent]) error {
	return status.Errorf(codes.Unimplemented, "method Subscribe not implemented")
}
func (UnimplementedGameEventsServer) StartGame(context.Context, *StartGameRequest) (*RoomGameDataReply, error) {
	return nil, status.Errorf(codes.Unimplemented, "method StartGame not implemented")
}
func (UnimplementedGameEventsServer) DepositWaste(context.Context, *DepositWasteRequest) (*emptypb.Empty, error) {
	return nil, status.Errorf(codes.Unimplemented, "method DepositWaste not implemented")
}
func (UnimplementedGameEventsServer) mustEmbedUnimplementedGameEventsServer() {}
func (UnimplementedGameEventsServer) testEmbeddedByValue()                    {}

// UnsafeGameEventsServer may be embedded to opt out of forward compatibility for this service.
// Use of this interface is not recommended, as added methods to GameEventsServer will
// result in compilation errors.
type UnsafeGameEventsServer interface {
	mustEmbedUnimplementedGameEventsServer()
}

func RegisterGameEventsServer(s grpc.ServiceRegistrar, srv GameEventsServer) {
	// If the following call pancis, it indicates UnimplementedGameEventsServer was
	// embedded by pointer and is nil.  This will cause panics if an
	// unimplemented method is ever invoked, so we test this at initialization
	// time to prevent it from happening at runtime later due to I/O.
	if t, ok := srv.(interface{ testEmbeddedByValue() }); ok {
		t.testEmbeddedByValue()
	}
	s.RegisterService(&GameEvents_ServiceDesc, srv)
}

func _GameEvents_Subscribe_Handler(srv interface{}, stream grpc.ServerStream) error {
	m := new(SubscriptionRequest)
	if err := stream.RecvMsg(m); err != nil {
		return err
	}
	return srv.(GameEventsServer).Subscribe(m, &grpc.GenericServerStream[SubscriptionRequest, ServerEvent]{ServerStream: stream})
}

// This type alias is provided for backwards compatibility with existing code that references the prior non-generic stream type by name.
type GameEvents_SubscribeServer = grpc.ServerStreamingServer[ServerEvent]

func _GameEvents_StartGame_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(StartGameRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(GameEventsServer).StartGame(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: GameEvents_StartGame_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(GameEventsServer).StartGame(ctx, req.(*StartGameRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _GameEvents_DepositWaste_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(DepositWasteRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(GameEventsServer).DepositWaste(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: GameEvents_DepositWaste_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(GameEventsServer).DepositWaste(ctx, req.(*DepositWasteRequest))
	}
	return interceptor(ctx, in, info, handler)
}

// GameEvents_ServiceDesc is the grpc.ServiceDesc for GameEvents service.
// It's only intended for direct use with grpc.RegisterService,
// and not to be introspected or modified (even as a copy)
var GameEvents_ServiceDesc = grpc.ServiceDesc{
	ServiceName: "ecoheroes.GameEvents",
	HandlerType: (*GameEventsServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "startGame",
			Handler:    _GameEvents_StartGame_Handler,
		},
		{
			MethodName: "depositWaste",
			Handler:    _GameEvents_DepositWaste_Handler,
		},
	},
	Streams: []grpc.StreamDesc{
		{
			StreamName:    "subscribe",
			Handler:       _GameEvents_Subscribe_Handler,
			ServerStreams: true,
		},
	},
	Metadata: "game-events.proto",
}
