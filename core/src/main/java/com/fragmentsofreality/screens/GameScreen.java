package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fragmentsofreality.PiecesOfAMan;

public class GameScreen extends ScreenAdapter {
    private final PiecesOfAMan game;
    private Stage stage;
    private Skin skin;

    public GameScreen(PiecesOfAMan game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        setupUI();
    }

    private void setupUI() {
        Table table = new Table();
        table.setFillParent(true);

        Label worldLabel = new Label("THE AWAKENING...\n\nYou have broken through the void.", skin);
        worldLabel.setAlignment(Align.center);

        table.add(worldLabel).expand();
        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // Subtle deep void blue tint to distinguish it from the pure black menu
        Gdx.gl.glClearColor(0.02f, 0.04f, 0.08f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}