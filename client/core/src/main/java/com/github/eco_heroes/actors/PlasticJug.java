package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Array;
import com.github.eco_heroes.proto.game_events.ContainerType;
import com.github.eco_heroes.proto.game_events.WasteType;
import com.github.eco_heroes.utils.GameState;
import com.github.eco_heroes.utils.WasteDisposer;

import java.awt.*;

public class PlasticJug extends TrashElement {
    private final TrashContainerElement correctContainer;
    private Action movement;

    public PlasticJug(Texture texture, int x, int y, TrashContainerElement correctContainer, Array<TrashContainerElement> containers) {
        super(texture, WasteType.PLASTIC_JUG, new Rectangle(x, y, texture.getWidth(), texture.getHeight()), x, y);
        this.correctContainer = correctContainer;
        this.containers = containers;
        isDragging = false;

        addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                System.out.println(getX());
                originalX = (int) getX();
                isDragging = true;
                clearActions();

                int newX = (int) (event.getStageX() - getWidth() / 2);
                int newY = (int) (event.getStageY() - getHeight() / 2);

                setPosition(newX, newY);
                getBounds().setLocation(newX, newY);
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                isDragging = false;

                if (droppedOverNothing()){
                    System.out.println(originalX+"lala"+originalY);
                    setPosition(originalX, originalY);
                } else if (getBounds().intersects(correctContainer.getBounds())) {
                    WasteDisposer.dispose(type, correctContainer.type);
                    System.out.println("¡La jug ha sido colocada en el contenedor!");
                    remove();
                } else {
                    WasteDisposer.dispose(type, ContainerType.CONTAINER_TYPE_UNKNOWN);
                    System.out.println("Te equivocaste >:(");
                    remove();
                };
            }
        });
    }
};
