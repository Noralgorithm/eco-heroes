package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;
import com.github.eco_heroes.proto.game_events.ContainerType;

import java.awt.*;

public class GreenContainer extends TrashContainerElement {
    public GreenContainer(Texture texture, int x, int y) {
        super(texture, ContainerType.GREEN, new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
