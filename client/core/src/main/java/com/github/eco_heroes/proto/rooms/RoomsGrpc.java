package com.github.eco_heroes.proto.rooms;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: rooms.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoomsGrpc {

  private RoomsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ecoheroes.Rooms";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.github.eco_heroes.proto.rooms.RoomDataReply> getCreateAndJoinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createAndJoin",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.github.eco_heroes.proto.rooms.RoomDataReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.github.eco_heroes.proto.rooms.RoomDataReply> getCreateAndJoinMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.github.eco_heroes.proto.rooms.RoomDataReply> getCreateAndJoinMethod;
    if ((getCreateAndJoinMethod = RoomsGrpc.getCreateAndJoinMethod) == null) {
      synchronized (RoomsGrpc.class) {
        if ((getCreateAndJoinMethod = RoomsGrpc.getCreateAndJoinMethod) == null) {
          RoomsGrpc.getCreateAndJoinMethod = getCreateAndJoinMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.github.eco_heroes.proto.rooms.RoomDataReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createAndJoin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.rooms.RoomDataReply.getDefaultInstance()))
              .setSchemaDescriptor(new RoomsMethodDescriptorSupplier("createAndJoin"))
              .build();
        }
      }
    }
    return getCreateAndJoinMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.eco_heroes.proto.rooms.JoinRequest,
      com.github.eco_heroes.proto.rooms.RoomDataReply> getJoinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "join",
      requestType = com.github.eco_heroes.proto.rooms.JoinRequest.class,
      responseType = com.github.eco_heroes.proto.rooms.RoomDataReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.eco_heroes.proto.rooms.JoinRequest,
      com.github.eco_heroes.proto.rooms.RoomDataReply> getJoinMethod() {
    io.grpc.MethodDescriptor<com.github.eco_heroes.proto.rooms.JoinRequest, com.github.eco_heroes.proto.rooms.RoomDataReply> getJoinMethod;
    if ((getJoinMethod = RoomsGrpc.getJoinMethod) == null) {
      synchronized (RoomsGrpc.class) {
        if ((getJoinMethod = RoomsGrpc.getJoinMethod) == null) {
          RoomsGrpc.getJoinMethod = getJoinMethod =
              io.grpc.MethodDescriptor.<com.github.eco_heroes.proto.rooms.JoinRequest, com.github.eco_heroes.proto.rooms.RoomDataReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "join"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.rooms.JoinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.rooms.RoomDataReply.getDefaultInstance()))
              .setSchemaDescriptor(new RoomsMethodDescriptorSupplier("join"))
              .build();
        }
      }
    }
    return getJoinMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.github.eco_heroes.proto.rooms.RoomsListReply> getFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetch",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.github.eco_heroes.proto.rooms.RoomsListReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.github.eco_heroes.proto.rooms.RoomsListReply> getFetchMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.github.eco_heroes.proto.rooms.RoomsListReply> getFetchMethod;
    if ((getFetchMethod = RoomsGrpc.getFetchMethod) == null) {
      synchronized (RoomsGrpc.class) {
        if ((getFetchMethod = RoomsGrpc.getFetchMethod) == null) {
          RoomsGrpc.getFetchMethod = getFetchMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.github.eco_heroes.proto.rooms.RoomsListReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.eco_heroes.proto.rooms.RoomsListReply.getDefaultInstance()))
              .setSchemaDescriptor(new RoomsMethodDescriptorSupplier("fetch"))
              .build();
        }
      }
    }
    return getFetchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoomsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoomsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoomsStub>() {
        @java.lang.Override
        public RoomsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoomsStub(channel, callOptions);
        }
      };
    return RoomsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoomsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoomsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoomsBlockingStub>() {
        @java.lang.Override
        public RoomsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoomsBlockingStub(channel, callOptions);
        }
      };
    return RoomsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoomsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoomsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoomsFutureStub>() {
        @java.lang.Override
        public RoomsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoomsFutureStub(channel, callOptions);
        }
      };
    return RoomsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAndJoin(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomDataReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAndJoinMethod(), responseObserver);
    }

    /**
     */
    default void join(com.github.eco_heroes.proto.rooms.JoinRequest request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomDataReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinMethod(), responseObserver);
    }

    /**
     */
    default void fetch(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomsListReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Rooms.
   */
  public static abstract class RoomsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RoomsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Rooms.
   */
  public static final class RoomsStub
      extends io.grpc.stub.AbstractAsyncStub<RoomsStub> {
    private RoomsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoomsStub(channel, callOptions);
    }

    /**
     */
    public void createAndJoin(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomDataReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAndJoinMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void join(com.github.eco_heroes.proto.rooms.JoinRequest request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomDataReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetch(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomsListReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Rooms.
   */
  public static final class RoomsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RoomsBlockingStub> {
    private RoomsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoomsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.eco_heroes.proto.rooms.RoomDataReply createAndJoin(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAndJoinMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.eco_heroes.proto.rooms.RoomDataReply join(com.github.eco_heroes.proto.rooms.JoinRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.github.eco_heroes.proto.rooms.RoomsListReply fetch(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Rooms.
   */
  public static final class RoomsFutureStub
      extends io.grpc.stub.AbstractFutureStub<RoomsFutureStub> {
    private RoomsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoomsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.eco_heroes.proto.rooms.RoomDataReply> createAndJoin(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAndJoinMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.eco_heroes.proto.rooms.RoomDataReply> join(
        com.github.eco_heroes.proto.rooms.JoinRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.eco_heroes.proto.rooms.RoomsListReply> fetch(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_AND_JOIN = 0;
  private static final int METHODID_JOIN = 1;
  private static final int METHODID_FETCH = 2;

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
        case METHODID_CREATE_AND_JOIN:
          serviceImpl.createAndJoin((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomDataReply>) responseObserver);
          break;
        case METHODID_JOIN:
          serviceImpl.join((com.github.eco_heroes.proto.rooms.JoinRequest) request,
              (io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomDataReply>) responseObserver);
          break;
        case METHODID_FETCH:
          serviceImpl.fetch((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.github.eco_heroes.proto.rooms.RoomsListReply>) responseObserver);
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
          getCreateAndJoinMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.github.eco_heroes.proto.rooms.RoomDataReply>(
                service, METHODID_CREATE_AND_JOIN)))
        .addMethod(
          getJoinMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.github.eco_heroes.proto.rooms.JoinRequest,
              com.github.eco_heroes.proto.rooms.RoomDataReply>(
                service, METHODID_JOIN)))
        .addMethod(
          getFetchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.github.eco_heroes.proto.rooms.RoomsListReply>(
                service, METHODID_FETCH)))
        .build();
  }

  private static abstract class RoomsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoomsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.eco_heroes.proto.rooms.RoomsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Rooms");
    }
  }

  private static final class RoomsFileDescriptorSupplier
      extends RoomsBaseDescriptorSupplier {
    RoomsFileDescriptorSupplier() {}
  }

  private static final class RoomsMethodDescriptorSupplier
      extends RoomsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RoomsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RoomsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoomsFileDescriptorSupplier())
              .addMethod(getCreateAndJoinMethod())
              .addMethod(getJoinMethod())
              .addMethod(getFetchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
