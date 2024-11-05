package com.github.eco_heroes.models;

import java.util.List;

public class Room {
    private final String id;
    private final int playerCount;
    private final int playersLimit;
    private final int me;
    private List<Room> rooms;

    public Room(String id, int playerCount, int playersLimit, int me) {
        this.id = id;
        this.playerCount = playerCount;
        this.playersLimit = playersLimit;
        this.me = me;
    }

    public String getId() {
        return id;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getPlayersLimit() { return playersLimit; }

    public int getMe() {
        return me;
    }
}
