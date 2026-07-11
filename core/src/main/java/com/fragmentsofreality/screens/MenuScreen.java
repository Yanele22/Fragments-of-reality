package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fragmentsofreality.PiecesOfAMan;
import com.fragmentsofreality.audio.AudioManager;

public class MenuScreen implements Screen {
    private final PiecesOfAMan game;
    private SpriteBatch batch;
    private BitmapFont font;

    public MenuScreen(PiecesOfAMan game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        // Uses libGDX's internal default font so we don't crash over missing asset paths
        font = new BitmapFont(); 
    }

    @Override
    public void render(float delta) {
        // 1. Clear the viewport to a deep black environment
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.05f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 2. Draw your title layouts on screen
        batch.begin();
        font.draw(batch, "Pieces of a Man", 260, 300);
        font.draw(batch, "Press SPACE to Awaken", 230, 200);
        font.draw(batch, "The Phantoms are waiting...", 220, 100);
        batch.end();

        // 3. Monitor input to advance states safely
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            // Trigger your background engine track to loop
            //AudioManager.getInstance().playAmbientWind();
            
            // Swap screens into your active grid canvas space
            game.setScreen(new PlayScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {}

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        if (batch != null) batch.dispose();
        if (font != null) font.dispose();
    }
}