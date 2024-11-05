package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.github.eco_heroes.proto.game_events.ContainerType;

import java.awt.*;

public class BrownContainer extends TrashContainerElement {
    public BrownContainer(Texture texture, int x, int y) {
        super(texture, ContainerType.DUMP, new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
