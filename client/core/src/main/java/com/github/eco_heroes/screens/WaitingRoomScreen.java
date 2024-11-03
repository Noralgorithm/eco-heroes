package com.github.eco_heroes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.eco_heroes.Main;
import com.github.eco_heroes.models.Player;

public class WaitingRoomScreen implements Screen {
    private final Main game; // Your main game class
    private Stage stage;
    private Skin skin;
    private TextField nameInputFieldUi;
    private List<Player> nameListUi;
    private Array<Player> players;
    private Texture backgroundTexture;

    public WaitingRoomScreen(final Main game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/uiskin.json")); // Load your skin file
        backgroundTexture = new Texture("background.png");

        players = new Array<>();
        // Add predefined players (you can replace these with actual data from a server or database)
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));

        // Create a TextField for the player's name
        nameInputFieldUi = new TextField("", skin);

        // Create a button to set the player's name
        TextButton setNameButton = new TextButton("Set My Name", skin);
        setNameButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                String name = nameInputFieldUi.getText();
                if (!name.isEmpty()) {
                    // Add the player's name to the list
                    players.add(new Player(name)); // Add the player to the array
                    nameListUi.setItems(players); // Update the list to show the new player
                    nameInputFieldUi.setText(""); // Clear the input field
                }
            }
        });

        // Create a button to start the game
        TextButton startGameButton = new TextButton("Start Game", skin);
        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
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

        // Create a list to display players
        nameListUi = new List<>(skin);
        nameListUi.setItems(players); // Set the initial items to the predefined players

        // Create a table to organize the UI elements
        Table table = new Table();
        table.setFillParent(true);
        table.add(nameInputFieldUi).fillX().padBottom(10);
        table.row();
        table.add(setNameButton).fillX().padBottom(10);
        table.row();
        table.add(nameListUi).fill().expand().padBottom(10); // Add the list to the table
        table.row(); // Move to the next row
        table.add(startGameButton).fillX().padTop(10); // Add the Start Game button at the bottom

        stage.addActor(table);
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
    }
}
