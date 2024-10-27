package com.github.eco_heroes.utils;

import com.badlogic.gdx.Gdx;

public class TrashElementUtils {
    private final int initialX;
    private final int initialY;

    public TrashElementUtils(){
        initialX = Gdx.graphics.getWidth();
        initialY = 100;
    }

    public int getInitialX(){
        return initialX;
    }

    public int getInitialY(){
        return initialY;
    }
}
