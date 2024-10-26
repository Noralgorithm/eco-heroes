package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Array;

import java.awt.*;

public class PlasticJug extends TrashElement {
    TrashContainerElement container;
    private Array<TrashContainerElement> containers;

    public PlasticJug(Texture texture, int x, int y, TrashContainerElement container, Array<TrashContainerElement> containers) {
        super(texture, "Plastic Jug", new Rectangle(x, y, texture.getWidth(), texture.getHeight()), x, y);
        this.container = container;
        this.containers = containers;

        addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                int newX = (int) (event.getStageX() - getWidth() / 2);
                int newY = (int) (event.getStageY() - getHeight() / 2);

                setPosition(newX, newY);
                getBounds().setLocation(newX, newY);
            }

            public void dragStop(InputEvent event, float x, float y, int pointer) {
                if (droppedOverNothing()){
                    setPosition(originalX, originalY);
                } else if (getBounds().intersects(container.getBounds())) {
                    System.out.println("¡La jug ha sido colocada en el contenedor!");
                    remove();
                } else {
                    System.out.println("Te equivocaste >:(");
                    remove();
                };
            }
        });
    }

    private boolean droppedOverNothing(){
        for (TrashContainerElement container : containers) {
            if (getBounds().intersects(container.getBounds())) {
                return false;
            }
        }
        return true;
    }
};
