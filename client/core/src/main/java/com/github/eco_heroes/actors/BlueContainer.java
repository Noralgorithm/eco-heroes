package com.github.eco_heroes.actors;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class BlueContainer extends TrashContainerElement {
    public BlueContainer(Texture texture, int x, int y) {
        super(texture, "Blue container", new Rectangle(x, y, texture.getWidth(), texture.getHeight()));
    }
}
