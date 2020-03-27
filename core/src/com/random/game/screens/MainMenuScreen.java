package com.random.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.random.game.MyGame;
import com.random.game.screens.GameScreen;

public class MainMenuScreen implements Screen {

    Music music;

    MyGame game;

    Texture exitButtonActive;
    Texture exitButtonInactive;

    Texture playButtonActive;
    Texture playButtonInactive;

    public MainMenuScreen(MyGame game){
        this.game = game;
        music = Gdx.audio.newMusic(Gdx.files.internal("raw/Peril.mp3"));
        music.setLooping(true);
        music.setVolume(0.35f);
        music.play();
        playButtonActive = new Texture("raw/playOn.png");
        playButtonInactive = new Texture("raw/playOff.png");
        exitButtonActive = new Texture("raw/exitOn.png");
        exitButtonInactive = new Texture("raw/exitOff.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.075f, 0.075f, 0.075f, 0.075f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        int x = MyGame.WIDTH/2 - 250 / 2;
        if(Gdx.input.getX() < x + 250 && Gdx.input.getX() > x && MyGame.HEIGHT - Gdx.input.getY() < 100 + 288 && MyGame.HEIGHT - Gdx.input.getY() > 288) {
            game.batch.draw(exitButtonActive, x, 288);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        } else {
            game.batch.draw(exitButtonInactive, x, 288);
        }

        x = MyGame.WIDTH / 2 - 250/2;
        if(Gdx.input.getX() < x + 250 && Gdx.input.getX() > x && MyGame.HEIGHT - Gdx.input.getY() < 432 + 100 && MyGame.HEIGHT - Gdx.input.getY() > 432){
            game.batch.draw(playButtonActive, x, 432);
            if (Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        } else {
            game.batch.draw(playButtonInactive, x, 432);
        }
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
        music.dispose();
    }
}