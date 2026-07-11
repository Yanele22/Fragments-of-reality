package com.fragmentsofreality.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Disposable;

public class AudioManager implements Disposable {
    private static AudioManager instance;

    // Music for long ambient loops
    private Music ambientWind;

    // Sound for instant sound effects (SFX)
    private Sound keystrokeClick;
    private Sound successChime;
    private Sound failureChord;

    private AudioManager() {
        loadAssets();
    }

    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    private void loadAssets() {
        try {
            // Long looping background wind
            ambientWind = Gdx.audio.newMusic(Gdx.files.internal("audio/wind_loop.mp3"));
            ambientWind.setLooping(true);
            ambientWind.setVolume(0.5f); // 50% volume so it doesn't drown out SFX

            // Sound effects (Ensure these match your core/assets/audio/ filenames exactly)
            keystrokeClick = Gdx.audio.newSound(Gdx.files.internal("audio/keystroke.mp3"));
            successChime = Gdx.audio.newSound(Gdx.files.internal("audio/success.mp3"));
            failureChord = Gdx.audio.newSound(Gdx.files.internal("audio/glitch_chord.mp3"));

        } catch (Exception e) {
            Gdx.app.error("AudioManager", "Failed to load audio assets. Verification fallback triggered.", e);
        }
    }

    // Call this as soon as PlayState starts
    public void playAmbientWind() {
        if (ambientWind != null && !ambientWind.isPlaying()) {
            ambientWind.play();
        }
    }

    // Call this to dim the environment when dialogue triggers
    public void muteAmbientWind() {
        if (ambientWind != null && ambientWind.isPlaying()) {
            ambientWind.pause();
        }
    }

    // Call this inside your typewriter text rendering loop
    public void playKeystroke() {
        if (keystrokeClick != null) {
            keystrokeClick.play(0.3f); // Lower volume so rapid clicks aren't deafening
        }
    }

    // Call this on a successful Helper choice
    public void playSuccess() {
        if (successChime != null) {
            successChime.play(0.8f);
        }
    }

    // Call this on a Deceiver trick/incorrect choice
    public void playFailure() {
        if (failureChord != null) {
            failureChord.play(0.8f);
        }
    }

    @Override
    public void dispose() {
        if (ambientWind != null) ambientWind.dispose();
        if (keystrokeClick != null) keystrokeClick.dispose();
        if (successChime != null) successChime.dispose();
        if (failureChord != null) failureChord.dispose();
    }
}
