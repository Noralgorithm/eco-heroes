package com.github.eco_heroes.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedTile {
    private final Animation<TextureRegion> animation;
    private final Texture texture;
    private float stateTime;

    public AnimatedTile() {
        // Cargar el sprite sheet
        texture = new Texture(Gdx.files.internal("conveyor_belt_tiles.png"));

        // Suponiendo que tienes 4 cuadros de animación en una fila
        int frameCount = 8;
        int frameWidth = 32;
        int frameHeight = 32;

        // Crear un Array para las regiones de los cuadros
        Array<TextureRegion> frames = new Array<>();

        // Extraer los cuadros de la textura
        for (int i = 4; i < frameCount; i++) {
            frames.add(new TextureRegion(texture, i * frameWidth, 0, frameWidth, frameHeight));
        }

        // Crear la animación (suponiendo que dura 0.1 segundos por cuadro)
        animation = new Animation<>(0.1f, frames, Animation.PlayMode.LOOP);
        stateTime = 0f;
    }

    public void update(float delta) {
        stateTime += delta;
    }

    public void draw(SpriteBatch batch, float x, float y) {
        batch.draw(animation.getKeyFrame(stateTime, true), x, y, 64, 64);

        /*TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);

        // Draw the current frame with scaling
        batch.draw(currentFrame, x, y, currentFrame.getRegionWidth() * scaleX, currentFrame.getRegionHeight() * scaleY);*/

    }

    public void dispose() {
        texture.dispose();
    }

    public void drawRow(SpriteBatch batch, float startX, float y, int count) {
        for (int i = 0; i < count; i++) {
            draw(batch, startX + (i * 64), y);
        }
    }
}
