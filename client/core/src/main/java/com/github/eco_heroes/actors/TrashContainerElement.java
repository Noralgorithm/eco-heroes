package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class TrashContainerElement extends Actor {
    private final Texture texture;
    protected String type;

    public TrashContainerElement(Texture texture, String type) {
        this.texture = texture;
        this.type = type;
        setSize(texture.getWidth(), texture.getHeight());

        // Agregar un listener para detectar cuando un ítem se suelta sobre el contenedor
        addListener(new DragListener() {
            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                // Aquí puedes implementar la lógica para verificar si un ítem de basura se soltó en este contenedor
                System.out.println("Ítem soltado en el contenedor");
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
