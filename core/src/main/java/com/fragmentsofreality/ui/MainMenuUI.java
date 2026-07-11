package com.fragmentsofreality.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

public class MainMenuUI {
    public Stage stage;
    public TextButton startButton;
    public TextButton exitButton;

    public MainMenuUI(Stage stage, Skin skin) {
        this.stage = stage;
        setupUI(skin);
    }

    private void setupUI(Skin skin) {
        Table table = new Table();
        table.setFillParent(true);

        Label titleLabel = new Label("Pieces of a Man", skin);
        titleLabel.setAlignment(Align.center);

        startButton = new TextButton("Awaken", skin);
        exitButton = new TextButton("Succumb", skin);

        table.add(titleLabel).padBottom(50).row();
        table.add(startButton).width(200).padBottom(20).row();
        table.add(exitButton).width(200);

        stage.addActor(table);
    }
}
