package com.github.eco_heroes.models;

public class Room {
    private final String name;
    private final int playerCount;

    public Room(String name, int playerCount) {
        this.name = name;
        this.playerCount = playerCount;
    }

    public String getName() {
        return name;
    }

    public int getPlayerCount() {
        return playerCount;
    }
}
