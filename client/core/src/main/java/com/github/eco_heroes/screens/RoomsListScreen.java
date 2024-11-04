package com.github.eco_heroes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.eco_heroes.Main;
import com.github.eco_heroes.models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomsListScreen implements Screen {
    private final Main game; // Suponiendo que tienes una clase principal llamada MyGame
    private Stage stage;
    private Skin skin;
    private List<Room> rooms; // Lista de salas de juego

    public RoomsListScreen(Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.skin = new Skin(Gdx.files.internal("ui/uiskin.json")); // Asegúrate de tener un skin

        this.rooms = new ArrayList<>(); // Inicializa la lista de salas

        // Crea algunas salas de ejemplo
        rooms.add(new Room("Sala 1", 3));
        rooms.add(new Room("Sala 2", 5));
        rooms.add(new Room("Sala 3", 2));

        setupUI();
    }

    private void setupUI() {
        Table table = new Table();
        //table.setDebug(true);
        table.setFillParent(true);
        stage.addActor(table);


        // title
        table.pad(16);
        Label titleLabel = new Label("Salas de Juego Actuales", skin);
        titleLabel.setColor(Color.BLACK);
        titleLabel.setAlignment(Align.center);
        table.add(titleLabel).growX().colspan(3).spaceBottom(64);

        // rooms
        for (Room room : rooms) {
            table.row().padBottom(16);
            table.defaults().growX();
            Label nameLabel = new Label("Sala "+room.getName(), skin);
            nameLabel.setColor(Color.BLACK);
            table.add(nameLabel);
            Label playerCount = new Label("Jugadores: "+String.valueOf(room.getPlayerCount()), skin);
            playerCount.setColor(Color.BLACK);
            table.add(playerCount);
            TextButton joinButton = new TextButton("Unirse", skin);
            joinButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println(room.getName());
                    game.setScreen(new WaitingRoomScreen(game));
                }
            });
            table.add(joinButton).center();
        }

        TextButton createRoomButton = new TextButton("Crear Nueva Sala", skin);
        createRoomButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                createNewRoom();
            }
        });
        table.row();
        table.add(createRoomButton).colspan(3).spaceTop(64);

    }

    private void createNewRoom() {
        // Lógica para crear una nueva sala
        game.setScreen(new WaitingRoomScreen(game));
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
