package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fragmentsofreality.PiecesOfAMan;
import com.fragmentsofreality.entities.Player;

public class PlayScreen implements Screen {
    private final PiecesOfAMan game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer debugRenderer;
    private Player player;

    public PlayScreen(PiecesOfAMan game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();
        debugRenderer = new ShapeRenderer();
        player = new Player(400, 300);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float dirX = 0;
        float dirY = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) dirY = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) dirY = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) dirX = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) dirX = 1;

        player.update(delta, dirX, dirY);

        camera.position.set(player.position.x + 16, player.position.y + 16, 0);
        camera.update();

        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Filled);

        debugRenderer.setColor(0.3f, 0.3f, 0.5f, 1f);
        debugRenderer.rect(200, 200, 32, 32);
        debugRenderer.rect(600, 400, 32, 32);
        debugRenderer.rect(400, 100, 32, 32);
        debugRenderer.rect(100, 500, 32, 32);

        debugRenderer.setColor(1, 1, 1, 1);
        debugRenderer.rect(player.position.x, player.position.y, player.bounds.width, player.bounds.height);
        
        debugRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        if (batch != null) batch.dispose();
        if (debugRenderer != null) debugRenderer.dispose();
    }
}