package com.fragmentsofreality;

import com.badlogic.gdx.Game;
import com.fragmentsofreality.screens.MenuScreen;

public class PiecesOfAMan extends Game {

    @Override
    public void create() {
        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
