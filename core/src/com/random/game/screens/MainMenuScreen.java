package com.random.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import com.random.game.MyGame;

public class MainMenuScreen implements Screen {

    //Music musicl;

    MyGame game;

    public MainMenuScreen(MyGame game){
        this.game = game;
        //put music here
    }

    @Override
    public void show() { }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.075f, 0.075f, 0.075f, 0.075f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        //put buttons here

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        //music.dispose();
    }
}
