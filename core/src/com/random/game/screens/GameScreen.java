package com.random.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
    OrthographicCamera camera;
    MyGame game;
    SpriteBatch batch;
    Assets assets;

    public GameScreen(MyGame game) {
        //save the game instance
        this.game = game;

        //create an orthographic camera
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 1280, 720);

        //
        assets = new Assets();
        assets.loadAtlas("pack/imgs.atlas");
        batch = new SpriteBatch();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Sprite sprite = assets.loadSprite("Snakey");
        sprite.setOrigin(0,0);
        sprite.scale(2);

        batch.begin();
            sprite.draw(batch);
        batch.end();
        camera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        batch.dispose();
        assets.dispose();
    }
}
