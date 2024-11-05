package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.github.eco_heroes.proto.game_events.ContainerType;

import java.awt.*;

public abstract class TrashContainerElement extends Actor {
    private final Texture texture;
    protected ContainerType type;
    protected Rectangle bounds;

    public TrashContainerElement(Texture texture, ContainerType type, Rectangle bounds) {
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
