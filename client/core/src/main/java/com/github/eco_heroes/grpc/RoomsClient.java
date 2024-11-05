package com.github.eco_heroes.grpc;

import com.github.eco_heroes.proto.rooms.JoinRequest;
import com.github.eco_heroes.proto.rooms.RoomDataReply;
import com.github.eco_heroes.proto.rooms.RoomsGrpc;
import com.github.eco_heroes.proto.rooms.RoomsListReply;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class RoomsClient {
    private final ManagedChannel channel;
    private final RoomsGrpc.RoomsBlockingStub blockingStub;
    private static RoomsClient instance;

    // Private constructor to prevent instantiation
    private RoomsClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext() // For development; use SSL in production
            .build();
        blockingStub = RoomsGrpc.newBlockingStub(channel);
    }

    // Public method to get the singleton instance
    public static synchronized RoomsClient getInstance(String host, int port) {
        if (instance == null) {
            instance = new RoomsClient(host, port);
        }
        return instance;
    }

    public RoomDataReply joinRoom(String roomId) {
        JoinRequest request = JoinRequest.newBuilder().setRoomId(roomId).build();
        return blockingStub.join(request);
    }

    public RoomsListReply fetchRooms() {
        return blockingStub.fetch(Empty.newBuilder().build());
    }

    public RoomDataReply createAndJoinRoom() {
        return blockingStub.createAndJoin(Empty.newBuilder().build());
    }

    public void shutdown() {
        channel.shutdown();
    }
}
