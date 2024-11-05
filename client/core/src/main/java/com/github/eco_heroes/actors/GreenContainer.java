package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class GreenContainer extends TrashContainerElement {
    public GreenContainer(Texture texture, int x, int y) {
        super(texture, "Green container", new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
