package com.fragmentsofreality.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TypeWriterLabel extends Label {
    private CharSequence fullText = "";
    private float characterDisplayDelay = 0.05f;
    private float timer = 0f;
    private int visibleCharacterIndex = 0;
    private boolean isFinished = false;

    public TypeWriterLabel(CharSequence text, Skin skin) {
        super("", skin);
        this.fullText = text;
        this.setWrap(true);
    }

    public TypeWriterLabel(CharSequence text, Skin skin, String styleName) {
        super("", skin, styleName);
        this.fullText = text;
        this.setWrap(true);
    }

    public void animateText(CharSequence newText) {
        this.fullText = newText;
        this.setText("");
        this.timer = 0f;
        this.visibleCharacterIndex = 0;
        this.isFinished = false;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (!isFinished && fullText.length() > 0) {
            timer += delta;

            if (timer >= characterDisplayDelay) {
                timer = 0f;
                visibleCharacterIndex++;

                if (visibleCharacterIndex > fullText.length()) {
                    visibleCharacterIndex = fullText.length();
                    isFinished = true;
                }

                super.setText(fullText.subSequence(0, visibleCharacterIndex));
            }
        }
    }

    public boolean isAnimationFinished() {
        return isFinished;
    }

    public void skipAnimation() {
        visibleCharacterIndex = fullText.length();
        super.setText(fullText);
        isFinished = true;
    }
}
