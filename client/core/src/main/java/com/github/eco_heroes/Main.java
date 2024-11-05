package com.github.eco_heroes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.eco_heroes.grpc.GameEventsClient;
import com.github.eco_heroes.grpc.RoomsClient;
import com.github.eco_heroes.screens.MainMenuScreen;
//import com.github.eco_heroes.services.RoomsClient;
import com.google.protobuf.Empty;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    //boilerplate
    public SpriteBatch batch;
    public BitmapFont font;
    //gRPC
    private RoomsClient roomsClient;
    private GameEventsClient gameEventsClient;

    //GRPC TESTS
    public Main() {
        /*var roomsClient = new RoomsClient();

        var newRoom = roomsClient.blockingStub.createAndJoin(Empty.newBuilder().build());
        var rooms = roomsClient.blockingStub.fetch(Empty.newBuilder().build());

        System.out.println(newRoom);
        System.out.println(rooms);*/
    }

    //x.x.x.x.x  <--- yo
    /*private ManagedChannel channel;
    private YourServiceGrpc.YourServiceStub asyncStub;
*/

    //load assets
    @Override
    public void create() {
        //services
        roomsClient = RoomsClient.getInstance("localhost", 50051);
        gameEventsClient = GameEventsClient.getInstance("localhost", 50051);

        //boilerplate
        batch = new SpriteBatch();
        font = new BitmapFont();
        setScreen(new MainMenuScreen(this));
    }

    public void resize(int width, int height) {
        //viewport.update(width, height, true); // true centers the camera
    }

    @Override
    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        roomsClient.shutdown();
        gameEventsClient.shutdown();
    }

    public RoomsClient getRoomsClient() {
        return roomsClient;
    }

    public GameEventsClient getGameEventsClient() {
        return gameEventsClient;
    }
}
