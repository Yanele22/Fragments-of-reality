package com.fragmentsofreality.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class DialogueBox extends Table {
    private TypeWriterLabel textLabel;
    private Skin skin;

    public DialogueBox(Skin skin) {
        super(skin);
        this.skin = skin;

        this.setBackground("default-pane");

        textLabel = new TypeWriterLabel("", skin);
        textLabel.setAlignment(Align.topLeft);

        this.add(textLabel).expand().fill().pad(20f);

        this.setVisible(false);
    }

    public void showDialogue(String text) {
        this.setVisible(true);
        textLabel.animateText(text);
    }

    public void hideDialogue() {
        this.setVisible(false);
    }

    public boolean isTextFinished() {
        return textLabel.isAnimationFinished();
    }

    public void skipText() {
        textLabel.skipAnimation();
    }
}
