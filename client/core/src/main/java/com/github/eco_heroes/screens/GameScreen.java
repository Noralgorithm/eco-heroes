package com.github.eco_heroes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.eco_heroes.Main;
import com.github.eco_heroes.utils.GameState;
import com.github.eco_heroes.utils.TrashElementUtils;
import com.github.eco_heroes.actors.*;

import java.util.Random;

public class GameScreen implements Screen {
    //utils
    final Main game;
    private final Random random;
    private final Stage stage;
    private final TrashElementUtils trashElementUtils;
    private long lastTrashElementTime;

    //textures
    Texture bottleTexture;
    Texture jugTexture;
    Texture blueContainerTexture;
    Texture yellowContainerTexture;

    //game logic
    private Array<TrashElement> trashElements;
    private Array<TrashContainerElement> containers;
    private int lives;
    private int points;

    //actors
    BlueContainer blueContainer;
    YellowContainer yellowContainer;

    public GameScreen(final Main game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
        random = new Random();
        trashElementUtils = new TrashElementUtils();
        Gdx.input.setInputProcessor(stage);

        containers = new Array<TrashContainerElement>();
        trashElements = new Array<TrashElement>();
        points = 0;

        //Textures
        //--TrashItems
        bottleTexture = new Texture("plastic_bottle.png");
        jugTexture = new Texture("plastic_jug.png");
        //--Containers
        blueContainerTexture = new Texture("container_blue.png");
        yellowContainerTexture = new Texture("container_yellow.png");

        //Actors
        blueContainer = new BlueContainer(blueContainerTexture, 300, 300);
        blueContainer.setPosition(300, 300);
        yellowContainer = new YellowContainer(yellowContainerTexture, 500, 300);
        yellowContainer.setPosition(500, 300);
        containers.add(blueContainer);
        containers.add(yellowContainer);

        //stage
        stage.addActor(blueContainer);
        stage.addActor(yellowContainer);


    }

    private void spawnTrashItem() {
        enum itemsEnum {
            PLASTIC_BOTTLE,
            PLASTIC_JUG
        }
        itemsEnum randomItem = itemsEnum.values()[ random.nextInt(itemsEnum.values().length)];

        switch(randomItem) {
            case PLASTIC_BOTTLE:
                System.out.println("bottle");
                PlasticBottle newBottle = new PlasticBottle(bottleTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newBottle.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newBottle); // Agrega la nueva botella al escenario
                trashElements.add(newBottle); // Agrega la nueva botella a la lista de elementos de basura

                break;
            case PLASTIC_JUG:
                System.out.println("jug");
                PlasticJug newJug = new PlasticJug(jugTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newJug.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newJug);
                trashElements.add(newJug);
                break;
        }

        lastTrashElementTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1); // Color de fondo blanco
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());

        game.batch.begin();
        stage.draw();
        game.font.draw(game.batch, "Vidas: " + GameState.getInstance().getLives(), 0, 480);

        for (TrashElement trashElement : trashElements) {
            trashElement.update(delta);
        }

        if (TimeUtils.nanoTime() - lastTrashElementTime > 5000000000L)
            spawnTrashItem();

        game.batch.end();
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

    public void loseLife() {
        lives--;
        if (lives <= 0) {
            System.out.println("¡Game Over!");
        }
    }
}
