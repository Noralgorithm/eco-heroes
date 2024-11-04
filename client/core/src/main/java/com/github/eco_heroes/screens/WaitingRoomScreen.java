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
import com.github.eco_heroes.models.Player;

public class WaitingRoomScreen implements Screen {
    private final Main game; // Your main game class
    private Stage stage;
    private Skin skin;
    private TextField nameInputFieldUi;
    private List<String> nameListUi; // Change to List<String> for player names
    private Array<Player> players;
    private Texture backgroundTexture;
    private boolean nameSet; // Flag to track if the name has been set

    public WaitingRoomScreen(final Main game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/uiskin.json")); // Load your skin file
        backgroundTexture = new Texture("background.png");

        players = new Array<>();
        players.add(new Player("lol"));
        nameSet = false; // Initialize the flag

        setUpUI();
    }

    private void setUpUI() {
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

        // Player's name
        table.row();
        Table playerNameTable = new Table();
        playerNameTable.defaults().space(8);
        Label nameLabel = new Label("Ingresa tu nombre: ", skin);
        nameLabel.setColor(Color.BLACK);
        playerNameTable.add(nameLabel);

        nameInputFieldUi = new TextField("", skin);
        nameInputFieldUi.setColor(Color.WHITE);
        playerNameTable.add(nameInputFieldUi);

        TextButton setNameButton = new TextButton("Unirse", skin);
        setNameButton.setColor(Color.GRAY);
        playerNameTable.add(setNameButton);
        table.add(playerNameTable).spaceBottom(15).width(64);

        setNameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String name = nameInputFieldUi.getText();
                if (!name.isEmpty() && !nameSet) { // Check if the name has not been set yet
                    players.add(new Player(name)); // Add the player to the array
                    nameInputFieldUi.setText(""); // Clear the input field
                    nameSet = true; // Set the flag to true
                    nameInputFieldUi.setDisabled(true); // Disable the input field
                    setNameButton.setDisabled(true); // Disable the button

                    // Update the player list display
                    updatePlayerListDisplay();
                }
            }
        });


        // Players list
        table.row();
        Label listTitleLabel = new Label("Jugadores en sala:", skin);
        listTitleLabel.setColor(Color.BLACK);
        table.add(listTitleLabel).spaceBottom(16);

        // Initialize the player list display
        nameListUi = new List<>(skin);
        nameListUi.setColor(Color.CLEAR);
        nameListUi.setItems(players); // Set initial items
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
