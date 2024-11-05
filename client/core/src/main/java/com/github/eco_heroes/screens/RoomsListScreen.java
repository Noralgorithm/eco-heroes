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
import com.github.eco_heroes.grpc.RoomsClient;
import com.github.eco_heroes.models.Room;
import com.github.eco_heroes.proto.rooms.PlayerInRoomData;
import com.github.eco_heroes.proto.rooms.RoomDataReply;
import com.github.eco_heroes.proto.rooms.RoomsListReply;

import java.util.ArrayList;
import java.util.List;

public class RoomsListScreen implements Screen {
    private final Main game;
    private Stage stage;
    private Skin skin;
    private List<Room> rooms;
    private RoomsListReply roomsListReply;

    public RoomsListScreen(Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        this.rooms = new ArrayList<>();

        setupUI();
        fetchRooms();
    }

    private void fetchRooms() {
        RoomsClient roomsClient = game.getRoomsClient();
        RoomsListReply reply = roomsClient.fetchRooms();

        rooms.clear();
        for (RoomDataReply roomData : reply.getRoomsList()) {
            rooms.add(new Room(roomData.getId(), roomData.getPlayersCount(), roomData.getPlayersLimit(), roomData.getMe().getNumber()));
        }
        updateUI();
    }

    private void updateUI() {
        stage.clear();
        setupUI();
    }

    private void setupUI() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Title
        table.pad(16);
        Label titleLabel = new Label("Salas de Juego Actuales", skin);
        titleLabel.setColor(Color.BLACK);
        titleLabel.setAlignment(Align.center);
        table.add(titleLabel).growX().colspan(3).spaceBottom(64);

        // Display rooms
        for (Room room : rooms) {
            table.row().padBottom(16);
            table.defaults().growX();
            Label nameLabel = new Label("Sala " + room.getId(), skin);
            nameLabel.setColor(Color.BLACK);
            table.add(nameLabel);
            Label playerCount = new Label("Jugadores: " + room.getPlayerCount() + "/" + room.getPlayersLimit(), skin);
            playerCount.setColor(Color.BLACK);
            table.add(playerCount);

            TextButton joinButton = new TextButton("Ver", skin);
            joinButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    joinRoom(room.getId());
                }
            });
            table.add(joinButton).center();
        }

        // Button to create a new room
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
        var res = game.getRoomsClient().createAndJoinRoom(); // Create the room on the server
        game.setScreen(new WaitingRoomScreen(game, res)); // Change to the waiting room screen
    }

    private void joinRoom(String id) {
        var res = game.getRoomsClient().joinRoom(id); // Join the room on the server

        game.setScreen(new WaitingRoomScreen(game, res)); // Change to the waiting room screen
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
