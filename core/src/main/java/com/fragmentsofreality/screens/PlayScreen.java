package com.fragmentsofreality.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fragmentsofreality.PiecesOfAMan;
import com.fragmentsofreality.entities.HelperNPC;
import com.fragmentsofreality.entities.Phantom;
import com.fragmentsofreality.entities.Player;
import com.fragmentsofreality.map.MapLoader;
import com.fragmentsofreality.ui.DialogueBox;
import com.fragmentsofreality.systems.DialogueManager;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.JsonValue;

public class PlayScreen implements Screen {
    private final PiecesOfAMan game;
    private OrthographicCamera camera;
    private ShapeRenderer renderer;
    private Player player;
    private MapLoader mapLoader;
    private DialogueManager dialogueSystem;

    private HelperNPC memoryKeeper;
    private Phantom shadow;

    private Stage uiStage;
    private Skin skin;
    private DialogueBox dialogueBox;
    private boolean isDialogueActive = false;

    public PlayScreen(PiecesOfAMan game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        renderer = new ShapeRenderer();
        mapLoader = new MapLoader();
        dialogueSystem = new DialogueManager();

        player = new Player(64, 64);
        memoryKeeper = new HelperNPC(300, 300);
        shadow = new Phantom(500, 500);

        uiStage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        dialogueBox = new DialogueBox(skin);
        dialogueBox.setFillParent(true);
        uiStage.addActor(dialogueBox);

        Gdx.input.setInputProcessor(uiStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.08f, 0.08f, 0.1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (isDialogueActive) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
                if (dialogueBox.isTextFinished()) {
                    dialogueBox.hideDialogue();
                    isDialogueActive = false;
                    memoryKeeper.hasGivenClue = true;

                    shadow.isAwake = true;
                } else {
                    dialogueBox.skipText();
                }
            }
        } else {
            float dirX = 0, dirY = 0;
            if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) dirY = 1;
            if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) dirY = -1;
            if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) dirX = -1;
            if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) dirX = 1;

            player.update(delta, dirX, dirY, mapLoader.wallBounds);
            shadow.hunt(player.position, delta);

            if (memoryKeeper.canInteract(player.bounds)) {
                isDialogueActive = true;
                JsonValue riddle = dialogueSystem.getRandomRiddle(1);
                String question = riddle != null ? riddle.getString("question") : "No memory found.";
                dialogueBox.showDialogue("Memory Fragment:\n\n'" + question + "'\n\n(Press SPACE to continue)");
            }

            if (shadow.isAwake && shadow.bounds.overlaps(player.bounds)) {
                player.position.set(64, 64);
                shadow.position.set(500, 500);
                shadow.isAwake = false;
                memoryKeeper.hasGivenClue = false;
            }
        }

        camera.position.lerp(new Vector3(player.position.x + 16, player.position.y + 16, 0), 0.1f);
        camera.update();

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(0.2f, 0.2f, 0.3f, 1f);
        for (Rectangle wall : mapLoader.wallBounds) {
            renderer.rect(wall.x, wall.y, wall.width, wall.height);
        }

        if (!memoryKeeper.hasGivenClue) {
            renderer.setColor(0.2f, 0.8f, 0.2f, 1f);
            renderer.rect(memoryKeeper.position.x, memoryKeeper.position.y, memoryKeeper.bounds.width, memoryKeeper.bounds.height);
        }

        if (shadow.isAwake) {
            renderer.setColor(0.8f, 0.1f, 0.1f, 1f);
            renderer.rect(shadow.position.x, shadow.position.y, shadow.bounds.width, shadow.bounds.height);
        }

        renderer.setColor(1f, 1f, 1f, 1f);
        renderer.rect(player.position.x, player.position.y, player.bounds.width, player.bounds.height);

        renderer.end();

        uiStage.act(delta);
        uiStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
        uiStage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}

    @Override
    public void dispose() {
        if (renderer != null) renderer.dispose();
        if (uiStage != null) uiStage.dispose();
        if (skin != null) skin.dispose();
    }
}
