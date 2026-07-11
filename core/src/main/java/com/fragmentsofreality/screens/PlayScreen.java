package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.fragmentsofreality.PiecesOfAMan;
import com.fragmentsofreality.entities.Player;
import com.fragmentsofreality.map.MapLoader;
import com.badlogic.gdx.math.Rectangle;

public class PlayScreen implements Screen {
    private final PiecesOfAMan game;
    private OrthographicCamera camera;
    private ShapeRenderer renderer;
    private Player player;
    private MapLoader mapLoader;

    public PlayScreen(PiecesOfAMan game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        renderer = new ShapeRenderer();

        mapLoader = new MapLoader();

        player = new Player(64, 64);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.08f, 0.08f, 0.1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float dirX = 0, dirY = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) dirY = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) dirY = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) dirX = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) dirX = 1;

        player.update(delta, dirX, dirY, mapLoader.wallBounds);

        camera.position.lerp(new Vector3(player.position.x + 16, player.position.y + 16, 0), 0.1f);
        camera.update();

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(0.2f, 0.2f, 0.3f, 1f);
        for (Rectangle wall : mapLoader.wallBounds) {
            renderer.rect(wall.x, wall.y, wall.width, wall.height);
        }

        renderer.setColor(1f, 1f, 1f, 1f);
        renderer.rect(player.position.x, player.position.y, player.bounds.width, player.bounds.height);

        renderer.end();
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
        if (renderer != null) renderer.dispose();
    }
}
