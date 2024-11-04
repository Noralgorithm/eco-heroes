package com.github.eco_heroes.services;

import com.github.eco_heroes.ServerUrl;
import com.github.eco_heroes.proto.game_events.GameEventsGrpc;
import io.grpc.ManagedChannelBuilder;

public class GameEventsClient {
    public io.grpc.Channel channel;
    public GameEventsGrpc.GameEventsBlockingStub blockingStub;
    public GameEventsGrpc.GameEventsStub asyncStub;

    public GameEventsClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(ServerUrl.HOST, ServerUrl.PORT).usePlaintext());
    }

    public GameEventsClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = GameEventsGrpc.newBlockingStub(channel);
        asyncStub = GameEventsGrpc.newStub(channel);
    }
}
