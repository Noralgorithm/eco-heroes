package com.github.eco_heroes.services;

import com.github.eco_heroes.ServerUrl;
import com.github.eco_heroes.proto.rooms.RoomsGrpc;
import io.grpc.ManagedChannelBuilder;

public class RoomsClient {
    public io.grpc.Channel channel;
    public RoomsGrpc.RoomsBlockingStub blockingStub;
    public RoomsGrpc.RoomsStub asyncStub;

    public RoomsClient() {
        this(ManagedChannelBuilder.forAddress(ServerUrl.HOST, ServerUrl.PORT).usePlaintext());
    }

    public RoomsClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = RoomsGrpc.newBlockingStub(channel);
        asyncStub = RoomsGrpc.newStub(channel);
    }
}
