package com.fragmentsofreality.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class AssetLoader {
    public final AssetManager manager = new AssetManager();

    // Textures
    public static final String PLAYER = "textures/player.png";
    public static final String NPC_HELPER = "textures/npc_helper.png";
    public static final String NPC_DECEIVER = "textures/npc_deceiver.png";
    public static final String PHANTOM = "textures/phantom.png";
    public static final String FRAGMENT = "textures/fragment.png";

    public void load() {
        // In a real project, these files would need to exist in the assets folder
        // manager.load(PLAYER, Texture.class);
        // manager.load(NPC_HELPER, Texture.class);
        // manager.load(NPC_DECEIVER, Texture.class);
        // manager.load(PHANTOM, Texture.class);
        // manager.load(FRAGMENT, Texture.class);
    }

    public void dispose() {
        manager.dispose();
    }
}
