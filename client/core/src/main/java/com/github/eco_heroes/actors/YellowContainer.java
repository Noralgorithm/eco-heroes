package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class YellowContainer extends TrashContainerElement {
    public YellowContainer(Texture texture, int x, int y) {
        super(texture, "Yellow container", new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
