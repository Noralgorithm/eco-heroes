package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.*;

public abstract class TrashElement extends Actor {
    protected Texture texture;
    protected String type;
    protected Rectangle bounds;
    protected int originalX;
    protected int originalY;

    public TrashElement(Texture texture, String type, Rectangle bounds, int originalX, int originalY) {
        this.texture = texture;
        this.type = type;
        this.bounds = bounds;
        this.originalX = originalX;
        this.originalY = originalY;

        setSize(texture.getWidth(), texture.getHeight()); // Set size based on texture
    }

    public Rectangle getBounds(){
        return bounds;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public String getType() {
        return type;
    }

    // Additional common methods for all trash elements can be added here
}
