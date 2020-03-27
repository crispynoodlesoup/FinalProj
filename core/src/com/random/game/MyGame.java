package com.random.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.random.game.screens.GameScreen;
import com.random.game.screens.MainMenuScreen;

public class MyGame extends Game {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this));
    }

    public void render(){
        super.render();
    }
}
