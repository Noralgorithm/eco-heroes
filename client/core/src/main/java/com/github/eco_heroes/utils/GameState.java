package com.github.eco_heroes.utils;

import com.github.eco_heroes.screens.GameScreen;

public class GameState {
    private static GameState instance;
    private int lives;

    private GameState() {
        lives = 3;
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
        if (lives <= 0) {
            System.out.println("¡Game Over!");
        } else {
            System.out.println("Vida perdida. Vidas restantes: " + lives);
        }
    }

    public void resetLives() {
        lives = 3;
    }
}
