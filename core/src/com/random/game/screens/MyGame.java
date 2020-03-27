package com.random.game.screens;

import com.badlogic.gdx.Game;
import com.random.game.screens.GameScreen;

public class MyGame extends Game {
    GameScreen screen;

    @Override
    public void create () {
        screen = new GameScreen(this);
        setScreen(screen);
    }
}
