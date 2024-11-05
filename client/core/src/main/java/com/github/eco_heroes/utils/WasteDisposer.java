package com.github.eco_heroes.utils;

import com.github.eco_heroes.ServerUrl;
import com.github.eco_heroes.grpc.GameEventsClient;
import com.github.eco_heroes.proto.game_events.ContainerType;
import com.github.eco_heroes.proto.game_events.WasteType;

public class WasteDisposer {
    public static int playerNumber;
    public static String roomId;

    public static void dispose(WasteType waste, ContainerType container) {
        var gameEventsClient = GameEventsClient.getInstance(ServerUrl.HOST, ServerUrl.PORT);

        gameEventsClient.depositWaste(playerNumber, roomId, waste, container);
    }

    public static void setPlayerNumber(int playerNumber) {
        WasteDisposer.playerNumber = playerNumber;
    }

    public static void setRoomId(String roomId) {
        WasteDisposer.roomId = roomId;
    }
}
