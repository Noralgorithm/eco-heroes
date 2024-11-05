package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.github.eco_heroes.proto.game_events.ContainerType;

import java.awt.*;

public class BlueContainer extends TrashContainerElement {
    public BlueContainer(Texture texture, int x, int y) {
        super(texture, ContainerType.BLUE, new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
