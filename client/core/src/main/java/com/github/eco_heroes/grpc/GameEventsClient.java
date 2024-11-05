package com.github.eco_heroes.grpc;

import com.github.eco_heroes.proto.game_events.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GameEventsClient {
    private final ManagedChannel channel;
    private final GameEventsGrpc.GameEventsBlockingStub blockingStub;
    private static GameEventsClient instance;

    // Private constructor to prevent instantiation
    private GameEventsClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext() // For development; use SSL in production
            .build();
        blockingStub = GameEventsGrpc.newBlockingStub(channel);
    }

    // Public method to get the singleton instance
    public static synchronized GameEventsClient getInstance(String host, int port) {
        if (instance == null) {
            instance = new GameEventsClient(host, port);
        }
        return instance;
    }

    // Subscribe to server events for a specific room and player number
    public Iterator<ServerEvent> subscribe(String roomId, int playerNumber) {
        SubscriptionRequest request = SubscriptionRequest.newBuilder()
            .setRoomId(roomId)
            .setPlayerNumber(playerNumber)
            .build();
        return blockingStub.subscribe(request);
    }

    // Start the game in a specific room
    public RoomGameDataReply startGame(String roomId) {
        StartGameRequest request = StartGameRequest.newBuilder()
            .setRoomId(roomId)
            .build();
        return blockingStub.startGame(request);
    }

    // Deposit waste into a specific container
    public void depositWaste(int playerNumber, String roomId, WasteType wasteType, ContainerType containerType) {
        DepositWasteRequest request = DepositWasteRequest.newBuilder()
            .setPlayerNumber(playerNumber)
            .setRoomId(roomId)
            .setWaste(wasteType)
            .setContainer(containerType)
            .build();
        blockingStub.depositWaste(request);
    }

    // Shutdown the channel when done
    public void shutdown() {
        channel.shutdown();
    }
}
