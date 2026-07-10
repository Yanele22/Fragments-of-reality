package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fragmentsofreality.PiecesOfAMan;
import com.fragmentsofreality.ui.DialogueBox;

public class MenuScreen extends ScreenAdapter {
    private final PiecesOfAMan game;
    private Stage stage;
    private Skin skin;
    private DialogueBox testDialogue;
    
    // Narrative sequence tracking
    private String[] dialogueLines;
    private int currentLineIndex = 0;

    public MenuScreen(PiecesOfAMan game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Sequence of story beats
        this.dialogueLines = new String[] {
            "This is a test of the typewriter effect. Focus your intentional attention here. The Phantoms are waiting...",
            "Fragments of memory scatter across the deep void. Who were you before the fracture?",
            "To find yourself, you must piece together the remnants of a man long forgotten."
        };

        setupUI();
    }

        private void setupUI() {
        Table rootTable = new Table();
        rootTable.setFillParent(true);

        Label titleLabel = new Label("Pieces of a Man", skin);
        titleLabel.setAlignment(Align.center);

        Label promptLabel = new Label("Press SPACE to Awaken", skin);
        promptLabel.setAlignment(Align.center);

        rootTable.add(titleLabel).expandX().padBottom(50f).row();
        rootTable.add(promptLabel).expandX();

        stage.addActor(rootTable);

        testDialogue = new DialogueBox(skin);
        testDialogue.setWidth(Gdx.graphics.getWidth());
        testDialogue.setHeight(150f);
        testDialogue.setPosition(0, 0);

        stage.addActor(testDialogue);

        // Feed the typewriter its first story line on startup
        testDialogue.showDialogue(dialogueLines[currentLineIndex]);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.05f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Constantly poll for player interaction frame-by-frame
        handleInput();

        stage.act(delta);
        stage.draw();
    }

    private void handleInput() {
        // Triggers exactly once the moment SPACE is tapped down
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            currentLineIndex++;
            
            if (currentLineIndex < dialogueLines.length) {
                // Clear out the old line and animate the new one smoothly
                testDialogue.showDialogue(dialogueLines[currentLineIndex]);
            } else {
                // Dialogue loop is finished! 
                // For now, we reset back to index 0. (Later, this transitions to your game world)
                currentLineIndex = 0;
                testDialogue.showDialogue(dialogueLines[currentLineIndex]);
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        if (testDialogue != null) {
            testDialogue.setWidth(width);
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}