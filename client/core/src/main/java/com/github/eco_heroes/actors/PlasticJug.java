package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class PlasticJug extends TrashElement {
    public PlasticJug(Texture texture) {
        super(texture, "Plastic Jug");
        addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                // Actualiza la posición del ítem mientras se arrastra
                setPosition(event.getStageX() - getWidth() / 2, event.getStageY() - getHeight() / 2);
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                // Lógica para cuando se suelta el ítem
                // Aquí puedes verificar si el ítem está en el contenedor correcto
            }
        });
    }
}
