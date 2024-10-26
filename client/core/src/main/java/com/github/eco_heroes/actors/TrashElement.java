package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class TrashElement extends Actor {
    protected Texture texture;
    protected String type;

    public TrashElement(Texture texture, String type) {
        this.texture = texture;
        this.type = type;
        setSize(texture.getWidth(), texture.getHeight()); // Set size based on texture
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
