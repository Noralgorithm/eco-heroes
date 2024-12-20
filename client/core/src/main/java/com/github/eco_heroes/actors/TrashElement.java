package com.github.eco_heroes.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.github.eco_heroes.proto.game_events.WasteType;

import java.awt.*;

public abstract class TrashElement extends Actor {
    protected Texture texture;
    protected WasteType type;
    protected Rectangle bounds;
    protected int originalX;
    protected int originalY;
    protected boolean isDragging;
    protected Array<TrashContainerElement> containers;
    protected Sound dropSound;
    protected Sound wrongSound;

    public TrashElement(Texture texture, WasteType type, Rectangle bounds, int originalX, int originalY) {
        this.texture = texture;
        this.type = type;
        this.bounds = bounds;
        this.originalX = originalX;
        this.originalY = originalY;

        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        wrongSound = Gdx.audio.newSound(Gdx.files.internal("wrong_drop.mp3"));




        setSize(texture.getWidth(), texture.getHeight()); // Set size based on texture
    }

    public Rectangle getBounds(){
        return bounds;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public WasteType getType() {
        return type;
    }

    public void update(float delta) {
        if (!isDragging) {
            moveBy(-1 * delta * 50, 0); // Mueve la botella 100 unidades por segundo a la izquierda
        }
    }

    protected boolean droppedOverNothing(){
        for (TrashContainerElement container : containers) {
            if (getBounds().intersects(container.getBounds())) {
                return false;
            }
        }
        return true;
    }
}
