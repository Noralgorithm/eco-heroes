package com.github.eco_heroes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.eco_heroes.Main;
import com.github.eco_heroes.ServerUrl;
import com.github.eco_heroes.grpc.GameEventsClient;
import com.github.eco_heroes.models.Player;
import com.github.eco_heroes.models.Room;
import com.github.eco_heroes.proto.rooms.RoomsListReply;
import com.github.eco_heroes.server_events.ServerEventsObservable;

import java.util.ArrayList;

public class WaitingRoomScreen implements Screen {
    private final Main game; // Your main game class
    private Stage stage;
    private Skin skin;
    private TextField nameInputFieldUi;
    private List<String> nameListUi; // Change to List<String> for player names
    private Array<Player> players;
    private Texture backgroundTexture;
    private boolean nameSet; // Flag to track if the name has been set
    private java.util.List<Room> rooms;
    private RoomsListReply reply;
    private Room roomData;


    public WaitingRoomScreen(final Main game, Room roomData) {
        this.game = game;
        this.roomData = roomData;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/uiskin.json")); // Load your skin file
        backgroundTexture = new Texture("background.png");

        players = new Array<>();
        nameSet = false; // Initialize the flag

        ServerEventsObservable.addObserver(event -> {
            switch (event.getEventCase()) {
                case PLAYERADDEDEVT -> {
                    if (!(event.getPlayerAddedEvt().getPlayerNumber() == roomData.getMe())) {
                        roomData.incrementPlayerCount();
                    }
                }
                case PLAYERREMOVEDEVT -> roomData.decrementPlayerCount();
            }
            updateUI();
            System.out.println("Received server event: " + event);
        });

        subscribeToGameEvents();
        setupUI();
    }


    private void subscribeToGameEvents() {
        var gameEventsClient = GameEventsClient.getInstance(ServerUrl.HOST, ServerUrl.PORT);

        gameEventsClient.subscribe(roomData.getId(), roomData.getMe());
    }


    private void setupUI() {
        Table table = new Table();
        table.pad(16);
        table.setDebug(true);
        table.setFillParent(true);
        stage.addActor(table);

        // Title
        Label titleLabel = new Label("Sala de Espera", skin);
        titleLabel.setColor(Color.BLACK);
        titleLabel.setAlignment(Align.center);
        table.add(titleLabel).growX().spaceBottom(32).center();

        // Players list
        table.row();
        Label listTitleLabel = new Label("Jugadores en sala:", skin);
        listTitleLabel.setColor(Color.BLACK);
        table.add(listTitleLabel).spaceBottom(16);

        var playersCount = roomData.getPlayerCount();
        var playersList = new ArrayList<String>();

        for (var i = 1; i <= playersCount; i++) {
            if (i == roomData.getMe()) {
                playersList.add("Jugador " + i + " (Tú)");
            } else {
                playersList.add("Jugador " + i);
            }
        }

        String[] playersArray = new String[playersList.size()];
        playersArray = playersList.toArray(playersArray);

        // Initialize the player list display
        nameListUi = new List<String>(skin);
        nameListUi.setColor(Color.CLEAR);
        nameListUi.setItems(playersArray); // Set initial items
        table.row();
        table.add(nameListUi).expandX(); // Add the list to the table

        //button ready
        table.row();
        TextButton readyButton = new TextButton("Listo", skin);
        table.add(readyButton).growX().spaceTop(16);
        readyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Set all players to ready
                for (Player player : players) {
                    player.setReady(true);
                }
                nameListUi.setItems(players); // Update the list to show the ready status

                // Transition to the game screen after a short delay
                Gdx.app.postRunnable(() -> {
                    try {
                        Thread.sleep(2000); // Show the ready status for 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    game.setScreen(new GameScreen(game)); // Transition to the game screen
                });

            }
        });
    }

    private void updateUI() {
        stage.clear();
        setupUI();
    }

    private void updatePlayerListDisplay() {
        nameListUi.setItems(players); // Update the list with current player names
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the background texture
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();

        // Update and draw the stage
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        backgroundTexture.dispose(); // Dispose of the background texture
    }
}
