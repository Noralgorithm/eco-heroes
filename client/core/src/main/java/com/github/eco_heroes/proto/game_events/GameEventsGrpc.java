package com.github.eco_heroes.proto.game_events;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: game-events.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameEventsGrpc {

  private GameEventsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ecoheroes.GameEvents";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.eco_heroes.proto.game_events.SubscriptionRequest,
      com.github.eco_heroes.proto.game_events.ServerEvent> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = com.github.eco_heroes.proto.game_events.SubscriptionRequest.class,
      responseType = com.github.eco_heroes.proto.game_events.ServerEvent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.eco_heroes.proto.game_events.SubscriptionRequest,
      com.github.eco_heroes.proto.game_events.ServerEvent> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.github.eco_heroes.proto.game_events.SubscriptionRequest, com.github.eco_heroes.proto.game_events.ServerEvent> getSubscribeMethod;
    if ((getSubscribeMethod = GameEventsGrpc.getSubscribeMethod) == null) {
      synchronized (GameEventsGrpc.class) {
        if ((getSubscribeMethod = GameEventsGrpc.getSubscribeMethod) == null) {
          GameEventsGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.github.eco_heroes.proto.game_events.SubscriptionRequest, com.github.eco_heroes.proto.game_events.ServerEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.game_events.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.game_events.ServerEvent.getDefaultInstance()))
              .setSchemaDescriptor(new GameEventsMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.eco_heroes.proto.game_events.StartGameRequest,
      com.github.eco_heroes.proto.game_events.RoomGameDataReply> getStartGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startGame",
      requestType = com.github.eco_heroes.proto.game_events.StartGameRequest.class,
      responseType = com.github.eco_heroes.proto.game_events.RoomGameDataReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.eco_heroes.proto.game_events.StartGameRequest,
      com.github.eco_heroes.proto.game_events.RoomGameDataReply> getStartGameMethod() {
    io.grpc.MethodDescriptor<com.github.eco_heroes.proto.game_events.StartGameRequest, com.github.eco_heroes.proto.game_events.RoomGameDataReply> getStartGameMethod;
    if ((getStartGameMethod = GameEventsGrpc.getStartGameMethod) == null) {
      synchronized (GameEventsGrpc.class) {
        if ((getStartGameMethod = GameEventsGrpc.getStartGameMethod) == null) {
          GameEventsGrpc.getStartGameMethod = getStartGameMethod =
              io.grpc.MethodDescriptor.<com.github.eco_heroes.proto.game_events.StartGameRequest, com.github.eco_heroes.proto.game_events.RoomGameDataReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "startGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.game_events.StartGameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.game_events.RoomGameDataReply.getDefaultInstance()))
              .setSchemaDescriptor(new GameEventsMethodDescriptorSupplier("startGame"))
              .build();
        }
      }
    }
    return getStartGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameEventsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameEventsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameEventsStub>() {
        @java.lang.Override
        public GameEventsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameEventsStub(channel, callOptions);
        }
      };
    return GameEventsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameEventsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameEventsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameEventsBlockingStub>() {
        @java.lang.Override
        public GameEventsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameEventsBlockingStub(channel, callOptions);
        }
      };
    return GameEventsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameEventsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameEventsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameEventsFutureStub>() {
        @java.lang.Override
        public GameEventsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameEventsFutureStub(channel, callOptions);
        }
      };
    return GameEventsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(com.github.eco_heroes.proto.game_events.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.game_events.ServerEvent> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    default void startGame(com.github.eco_heroes.proto.game_events.StartGameRequest request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.game_events.RoomGameDataReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartGameMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GameEvents.
   */
  public static abstract class GameEventsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GameEventsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GameEvents.
   */
  public static final class GameEventsStub
      extends io.grpc.stub.AbstractAsyncStub<GameEventsStub> {
    private GameEventsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameEventsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameEventsStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(com.github.eco_heroes.proto.game_events.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.game_events.ServerEvent> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startGame(com.github.eco_heroes.proto.game_events.StartGameRequest request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.game_events.RoomGameDataReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GameEvents.
   */
  public static final class GameEventsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GameEventsBlockingStub> {
    private GameEventsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameEventsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameEventsBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.github.eco_heroes.proto.game_events.ServerEvent> subscribe(
        com.github.eco_heroes.proto.game_events.SubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.eco_heroes.proto.game_events.RoomGameDataReply startGame(com.github.eco_heroes.proto.game_events.StartGameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartGameMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GameEvents.
   */
  public static final class GameEventsFutureStub
      extends io.grpc.stub.AbstractFutureStub<GameEventsFutureStub> {
    private GameEventsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameEventsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameEventsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.eco_heroes.proto.game_events.RoomGameDataReply> startGame(
        com.github.eco_heroes.proto.game_events.StartGameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_START_GAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((com.github.eco_heroes.proto.game_events.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.game_events.ServerEvent>) responseObserver);
          break;
        case METHODID_START_GAME:
          serviceImpl.startGame((com.github.eco_heroes.proto.game_events.StartGameRequest) request,
              (io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.game_events.RoomGameDataReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.github.eco_heroes.proto.game_events.SubscriptionRequest,
              com.github.eco_heroes.proto.game_events.ServerEvent>(
                service, METHODID_SUBSCRIBE)))
        .addMethod(
          getStartGameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.github.eco_heroes.proto.game_events.StartGameRequest,
              com.github.eco_heroes.proto.game_events.RoomGameDataReply>(
                service, METHODID_START_GAME)))
        .build();
  }

  private static abstract class GameEventsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameEventsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.eco_heroes.proto.game_events.GameEventsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameEvents");
    }
  }

  private static final class GameEventsFileDescriptorSupplier
      extends GameEventsBaseDescriptorSupplier {
    GameEventsFileDescriptorSupplier() {}
  }

  private static final class GameEventsMethodDescriptorSupplier
      extends GameEventsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GameEventsMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameEventsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameEventsFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getStartGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
