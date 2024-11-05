package com.github.eco_heroes.grpc;

import com.github.eco_heroes.server_events.ServerEventsListener;
import com.github.eco_heroes.proto.game_events.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GameEventsClient {
    private final ManagedChannel channel;
    private final GameEventsGrpc.GameEventsBlockingStub blockingStub;
    private final GameEventsGrpc.GameEventsStub asyncStub;
    private static GameEventsClient instance;
    private final ServerEventsListener serverEventsListener;

    // Private constructor to prevent instantiation
    private GameEventsClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext() // For development; use SSL in production
            .build();
        blockingStub = GameEventsGrpc.newBlockingStub(channel);
        asyncStub = GameEventsGrpc.newStub(channel);

        serverEventsListener = new ServerEventsListener();
    }

    // Public method to get the singleton instance
    public static synchronized GameEventsClient getInstance(String host, int port) {
        if (instance == null) {
            instance = new GameEventsClient(host, port);
        }
        return instance;
    }

    // Subscribe to server events for a specific room and player number
    public void subscribe(String roomId, int playerNumber) {
        SubscriptionRequest request = SubscriptionRequest.newBuilder()
            .setRoomId(roomId)
            .setPlayerNumber(playerNumber)
            .build();

        asyncStub.subscribe(request,serverEventsListener);
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
