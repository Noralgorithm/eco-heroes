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
import com.github.eco_heroes.models.Room;
import com.github.eco_heroes.proto.game_events.WasteType;
import com.github.eco_heroes.server_events.ServerEventsObservable;
import com.github.eco_heroes.utils.GameState;
import com.github.eco_heroes.utils.TrashElementUtils;
import com.github.eco_heroes.actors.*;
import com.github.eco_heroes.utils.WasteDisposer;

import java.util.Random;

public class GameScreen implements Screen {
    //utils
    final Main game;
    private final Random random;
    private final Stage stage;
    private final TrashElementUtils trashElementUtils;
    private long lastTrashElementTime;
    private Room room;

    //textures
    Texture bottleTexture;
    Texture jugTexture;
    Texture plasticDetergentBottleTexture;
    Texture paperNewspaperTexture;
    Texture paperBagTexture;
    Texture paperBoxTexture;
    Texture glassSodaBottleTexture;
    Texture glassJarTexture;
    Texture glassBottleTexture;
    Texture metalSmallCanTexture;
    Texture metalCanTexture;
    Texture metalSodaCanTexture;
    Texture polystyreneCupTexture;
    Texture pizzaBoxTexture;
    Texture mugTexture;
    Texture aerosolCanTexture;

    Texture blueContainerTexture;
    Texture yellowContainerTexture;
    Texture greenContainerTexture;

    Texture backgroundTexture;

    //game logic
    private Array<TrashElement> trashElements;
    private Array<TrashContainerElement> containers;
    private int lives;
    private int points;

    //actors
    BlueContainer blueContainer;
    YellowContainer yellowContainer;
    GreenContainer greenContainer;
    AnimatedTile animatedTile;

    public GameScreen(final Main game, Room room){
        this.game = game;
        this.room = room;
        stage = new Stage(new ScreenViewport());
        random = new Random();
        trashElementUtils = new TrashElementUtils();

        GameState.setPlayersCount(room.getPlayerCount());

        WasteDisposer.setPlayerNumber(room.getMe());
        WasteDisposer.setRoomId(room.getId());

        ServerEventsObservable.addObserver(event -> {
            switch (event.getEventCase()) {
                case WASTEGENERATEDEVT -> {
                    spawnTrashItem(event.getWasteGeneratedEvt().getWaste());
                }
                case LIFELOSTEVT -> {
                    var playerNumber = event.getLifeLostEvt().getPlayerNumber();
                    GameState.getInstance().loseLife(playerNumber);
                }
                case GAMEENDEDEVT -> {
                    var winnerNumber = event.getGameEndedEvt().getWinnerNumber();

                    if (winnerNumber == room.getMe()) {
                        //TODO: Go to WinScreen
                    }

                    game.setScreen(new GameOverScreen(game));
                }
            }
        });

        Gdx.input.setInputProcessor(stage);

        containers = new Array<TrashContainerElement>();
        trashElements = new Array<TrashElement>();
        points = 0;

        //Textures
        //--TrashItems
        bottleTexture = new Texture("plastic_bottle.png");
        jugTexture = new Texture("plastic_jug.png");
        plasticDetergentBottleTexture = new Texture("plastic_detergent_bottle.png");
        paperNewspaperTexture = new Texture("paper_newspaper.png");
        paperBagTexture = new Texture("paper_bag.png");
        paperBoxTexture = new Texture("paper_box.png");
        glassSodaBottleTexture = new Texture("glass_soda_bottle.png");
        glassJarTexture = new Texture("glass_jar.png");
        glassBottleTexture = new Texture("glass_bottle.png");
        metalSmallCanTexture = new Texture("metal_small_can.png");
        metalCanTexture = new Texture("metal_can.png");
        metalSodaCanTexture = new Texture("metal_soda_can.png");
        polystyreneCupTexture = new Texture("polystyrene_cup.png");
        pizzaBoxTexture = new Texture("pizza_box.png");
        mugTexture = new Texture("mug.png");
        aerosolCanTexture = new Texture("aerosol_can.png");
        //--bg
        backgroundTexture = new Texture("game_bg.png");
        //--Containers
        blueContainerTexture = new Texture("container_blue.png");
        yellowContainerTexture = new Texture("container_yellow.png");
        greenContainerTexture = new Texture("container_green.png");

        //Actors
        animatedTile = new AnimatedTile();
        blueContainer = new BlueContainer(blueContainerTexture, 100, 300);
        blueContainer.setPosition(100, 300);
        yellowContainer = new YellowContainer(yellowContainerTexture, 300, 300);
        yellowContainer.setPosition(300, 300);
        greenContainer = new GreenContainer(greenContainerTexture, 500, 300);
        greenContainer.setPosition(500, 300);
        containers.add(blueContainer);
        containers.add(yellowContainer);
        containers.add(greenContainer);

        //stage
        stage.addActor(blueContainer);
        stage.addActor(yellowContainer);
        stage.addActor(greenContainer);


    }

    private void spawnTrashItem(WasteType waste) {
        switch (waste) {
            case PLASTIC_BOTTLE:
                System.out.println("bottle");
                PlasticBottle newBottle = new PlasticBottle(bottleTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), yellowContainer, containers);
                newBottle.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newBottle); // Agrega la nueva botella al escenario
                trashElements.add(newBottle); // Agrega la nueva botella a la lista de elementos de basura
                break;

            case PLASTIC_JUG:
                System.out.println("jug");
                PlasticJug newJug = new PlasticJug(jugTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), yellowContainer, containers);
                newJug.setScale(2f);
                newJug.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newJug);
                trashElements.add(newJug);
                break;

            case PLASTIC_DETERGENT_BOTTLE:
                System.out.println("detergent bottle");
                PlasticDetergentBottle newDetergentBottle = new PlasticDetergentBottle(plasticDetergentBottleTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), yellowContainer, containers);
                newDetergentBottle.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newDetergentBottle);
                trashElements.add(newDetergentBottle);
                break;

            case PAPER_NEWSPAPER:
                System.out.println("newspaper");
                PaperNewspaper newPaperNewspaper = new PaperNewspaper(paperNewspaperTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newPaperNewspaper.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newPaperNewspaper);
                trashElements.add(newPaperNewspaper);
                break;

            case PAPER_BAG:
                System.out.println("paper bag");
                PaperBag newPaperBag = new PaperBag(paperBagTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newPaperBag.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newPaperBag);
                trashElements.add(newPaperBag);
                break;

            case PAPER_BOX:
                System.out.println("paper box");
                PaperBox newPaperBox = new PaperBox(paperBoxTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newPaperBox.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newPaperBox);
                trashElements.add(newPaperBox);
                break;

            case GLASS_SODA_BOTTLE:
                System.out.println("glass soda bottle");
                GlassSodaBottle newGlassSodaBottle = new GlassSodaBottle(glassSodaBottleTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), greenContainer, containers);
                newGlassSodaBottle.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newGlassSodaBottle);
                trashElements.add(newGlassSodaBottle);
                break;

            case GLASS_JAR:
                System.out.println("glass jar");
                GlassJar newGlassJar = new GlassJar(glassJarTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), greenContainer, containers);
                newGlassJar.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newGlassJar);
                trashElements.add(newGlassJar);
                break;

            case GLASS_BOTTLE:
                System.out.println("glass bottle");
                GlassBottle newGlassBottle = new GlassBottle(glassBottleTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), greenContainer, containers);
                newGlassBottle.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newGlassBottle);
                trashElements.add(newGlassBottle);
                break;

            case METAL_SMALL_CAN:
                System.out.println("metal small can");
                MetalSmallCan newMetalSmallCan = new MetalSmallCan(metalSmallCanTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), yellowContainer, containers);
                newMetalSmallCan.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newMetalSmallCan);
                trashElements.add(newMetalSmallCan);
                break;

            case METAL_CAN:
                System.out.println("metal can");
                MetalCan newMetalCan = new MetalCan(metalCanTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), yellowContainer, containers);
                newMetalCan.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newMetalCan);
                trashElements.add(newMetalCan);
                break;

            case METAL_SODA_CAN:
                System.out.println("metal soda can");
                MetalSodaCan newMetalSodaCan = new MetalSodaCan(metalSodaCanTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), yellowContainer, containers);
                newMetalSodaCan.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newMetalSodaCan);
                trashElements.add(newMetalSodaCan);
                break;

            case POLYSTYRENE_CUP:
                System.out.println("polystyrene cup");
                PolystyreneCup newPolystyreneCup = new PolystyreneCup(polystyreneCupTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newPolystyreneCup.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newPolystyreneCup);
                trashElements.add(newPolystyreneCup);
                break;

            case PIZZA_BOX:
                System.out.println("pizza box");
                PizzaBox newPizzaBox = new PizzaBox(pizzaBoxTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newPizzaBox.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newPizzaBox);
                trashElements.add(newPizzaBox);
                break;

            case MUG:
                System.out.println("mug");
                Mug newMug = new Mug(mugTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newMug.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newMug);
                trashElements.add(newMug);
                break;

            case AEROSOL_CAN:
                System.out.println("aerosol can");
                AerosolCan newAerosolCan = new AerosolCan(aerosolCanTexture, trashElementUtils.getInitialX(), trashElementUtils.getInitialY(), blueContainer, containers);
                newAerosolCan.setPosition(trashElementUtils.getInitialX(), trashElementUtils.getInitialY());

                stage.addActor(newAerosolCan);
                trashElements.add(newAerosolCan);
                break;

            case WASTE_TYPE_UNKNOWN:
            default:
                System.out.println("Unknown waste type");
                break;
        }

        lastTrashElementTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1); // Color de fondo blanco
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());

        animatedTile.update(delta);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.font.draw(game.batch, "Vidas: " + GameState.getInstance().getLives(room.getMe()), 50, 50);
        animatedTile.drawRow(game.batch, 0, 90, 15);
        game.batch.end();

        stage.draw();


        for (TrashElement trashElement : trashElements) {
            trashElement.update(delta);
        }


        if (GameState.getInstance().getLives(room.getMe()) <= 0) {
            game.setScreen(new GameOverScreen(game));
            dispose();
        }
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
