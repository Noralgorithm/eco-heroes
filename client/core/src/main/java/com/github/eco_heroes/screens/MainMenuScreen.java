package com.github.eco_heroes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.github.eco_heroes.Main;

/** First screen of the application. Displayed after the application is created. */
public class MainMenuScreen implements Screen {
    final Main game;
    OrthographicCamera camera;
    //BitmapFont font;
    BitmapFont titleFont;

    Texture backgroundTexture;

    public MainMenuScreen(final Main game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        backgroundTexture = new Texture("bg1.png");
        //titleFont = new BitmapFont();
        /*titleFont.getData().setScale(1.5f);
        titleFont.setColor(Color.RED);*/
        game.font.getData().setScale(2f);
        game.font.setColor(Color.BLACK);
    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();

        if (Gdx.input.isTouched()) {
            //game.setScreen(new GameScreen(game));
            //game.setScreen(new WaitingRoomScreen(game));
            game.setScreen(new RoomsListScreen(game));

            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
