package com.github.eco_heroes.models;

public class Player {
    private final String name;
    private boolean ready;

    public Player(String name) {
        this.name = name;
        this.ready = false; // Default to not ready
    }

    public String getName() {
        return name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public String toString() {
        return name + (ready ? " (Ready)" : " (Not Ready)");
    }
}
