package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fragmentsofreality.PiecesOfAMan;

public class PlayScreen implements Screen {
    private final PiecesOfAMan game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer debugRenderer;

    // Player placeholder grid positions
    private float playerX = 400;
    private float playerY = 300;
    private float moveSpeed = 200f; // Pixels per second

    public PlayScreen(PiecesOfAMan game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600); // Standard layout size
        batch = new SpriteBatch();
        debugRenderer = new ShapeRenderer(); // ShapeRenderer used for rapid debugging
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Player input polling
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) playerY += moveSpeed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) playerY -= moveSpeed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) playerX -= moveSpeed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) playerX += moveSpeed * delta;

        // Camera follow locking
        camera.position.set(playerX, playerY, 0);
        camera.update();

        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // --- DRAW BACKGROUND TILES FOR REFERENCE ---
        // This paints a collection of colored static blocks at fixed map coordinates
        debugRenderer.setColor(0.3f, 0.3f, 0.5f, 1f); // Blueish blocks
        debugRenderer.rect(200, 200, 32, 32);
        debugRenderer.rect(600, 400, 32, 32);
        debugRenderer.rect(400, 100, 32, 32);
        debugRenderer.rect(100, 500, 32, 32);

        // --- DRAW PLAYER CUBE ---
        debugRenderer.setColor(1, 1, 1, 1); // White block
        debugRenderer.rect(playerX - 16, playerY - 16, 32, 32);
        
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