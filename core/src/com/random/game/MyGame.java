package com.random.game;

import com.badlogic.gdx.Game;

public class MyGame extends Game {
    GameScreen screen;

    @Override
    public void create () {
        screen = new GameScreen(this);
        setScreen(screen);
    }
}
