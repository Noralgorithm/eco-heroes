package com.github.eco_heroes.models;

import java.util.List;

public class Room {
    private final String id;
    private final int playerCount;
    private final int me;
    private List<Room> rooms;

    public Room(String id, int playerCount, int me) {
        this.id = id;
        this.playerCount = playerCount;
        this.me = me;
    }

    public String getId() {
        return id;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getMe() {
        return me;
    }
}
