package com.github.eco_heroes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.eco_heroes.Main;
import com.github.eco_heroes.actors.*;

import java.awt.*;
import java.util.Random;

public class GameScreen implements Screen {
    //final Main game;
    Random random;
    private final Stage stage;

    private Array<TrashContainerElement> containers;

    Texture bottleTexture;
    Texture jugTexture;
    Texture blueContainerTexture;
    Texture yellowContainerTexture;
    Array<TrashElement> trashElements;
    PlasticBottle bottle;
    BlueContainer blueContainer;
    YellowContainer yellowContainer;


    public GameScreen(final Main game){
        stage = new Stage(new ScreenViewport());
        random = new Random();
        Gdx.input.setInputProcessor(stage);

        containers = new Array<TrashContainerElement>();

        //Textures
        //--TrashItems
        bottleTexture = new Texture("plastic_bottle.png");
        jugTexture = new Texture("plastic_jug.png");
        //--Containers
        blueContainerTexture = new Texture("container_blue.png");
        yellowContainerTexture = new Texture("container_yellow.png");

        //Actors
        blueContainer = new BlueContainer(blueContainerTexture, 300, 100);
        blueContainer.setPosition(300, 100);
        yellowContainer = new YellowContainer(yellowContainerTexture, 500, 100);
        yellowContainer.setPosition(500, 100);

        containers.add(blueContainer);
        containers.add(yellowContainer);

        bottle = new PlasticBottle(bottleTexture, 100, 100, blueContainer, containers);
        bottle.setPosition(100, 100);
        TrashElement jug = new PlasticJug(jugTexture, 200, 100, yellowContainer, containers);
        jug.setPosition(200, 100);

        //stage
        stage.addActor(blueContainer);
        stage.addActor(yellowContainer);
        stage.addActor(bottle);
        stage.addActor(jug);
    }

    private void spawnTrashItem() {
        enum itemsEnum {
            PLASTIC_BOTTLE,
            PLASTIC_JUG
        }
        itemsEnum randomItem = itemsEnum.values()[ random.nextInt(itemsEnum.values().length)];

        switch(randomItem) {
            case PLASTIC_BOTTLE:
                System.out.println("Low level");
                break;
            case PLASTIC_JUG:
                System.out.println("Medium level");
                break;
        }

        //trashElements.add();
        /*Rectangle bottle = new Rectangle();
        bottle.x = MathUtils.random(0, 800 - 64);
        bottle.y = 480;
        bottle.width = 64;
        bottle.height = 64;
        bottlesRectangles.add(bottle);
        lastBottleTime = TimeUtils.nanoTime();*/
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1); // Color de fondo blanco
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        //spawnTrashItem();
    }



    @Override
    public void show() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        bottleTexture.dispose();
    }
}
