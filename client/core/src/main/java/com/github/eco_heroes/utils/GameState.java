package com.github.eco_heroes.utils;

import java.util.HashMap;
import java.util.Map;

public class GameState {
    private static GameState instance;
    private Map<Integer, Integer> playersLives;

    public static int playersCount;

    private GameState() {
        playersLives = new HashMap<>();

        for (int i = 1; i <= playersCount; i++) {
            playersLives.put(i, 3);
        }
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public int getLives(int playerNumber) {
        return playersLives.get(playerNumber);
    }

    public Map<Integer, Integer> getAllPlayersLives() {return playersLives;}

    public void loseLife(int playerNumber) {
        var newPlayerLives = playersLives.get(playerNumber) - 1;
        playersLives.put(playerNumber, newPlayerLives);

        if (newPlayerLives <= 0) {
            System.out.println("¡Game Over!");
        } else {
            System.out.println("Vida perdida. Vidas restantes: " + playersLives);
        }
    }


    public static void setPlayersCount(int playersCount) {
        GameState.playersCount = playersCount;
    }
}
