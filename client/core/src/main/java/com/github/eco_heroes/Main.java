package com.github.eco_heroes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.github.eco_heroes.screens.MainMenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    //boilerplate
    public SpriteBatch batch;
    public BitmapFont font;

    SpriteBatch spriteBatch;
    FitViewport viewport;
    Vector2 touchPos;
    float dropTimer;

    //x.x.x.x.x  <--- yo
    /*private ManagedChannel channel;
    private YourServiceGrpc.YourServiceStub asyncStub;
*/
    //load assets
    @Override
    public void create() {
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
    }
}
