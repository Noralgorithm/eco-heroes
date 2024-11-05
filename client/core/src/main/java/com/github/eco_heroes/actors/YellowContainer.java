package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.github.eco_heroes.proto.game_events.ContainerType;

import java.awt.*;

public class YellowContainer extends TrashContainerElement {
    public YellowContainer(Texture texture, int x, int y) {
        super(texture, ContainerType.YELLOW, new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
