package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.*;

public abstract class TrashContainerElement extends Actor {
    private final Texture texture;
    protected String type;
    protected Rectangle bounds;

    public TrashContainerElement(Texture texture, String type, Rectangle bounds) {
        this.texture = texture;
        this.type = type;
        this.bounds = bounds;

        setSize(texture.getWidth(), texture.getHeight());
    }

    public Rectangle getBounds(){
        return bounds;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
