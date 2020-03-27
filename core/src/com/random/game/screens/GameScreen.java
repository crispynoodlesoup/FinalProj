package com.random.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.random.game.MyGame;
import com.random.game.assets.Assets;
import com.random.game.assets.Board;
import com.random.game.assets.Enemies;

public class GameScreen implements Screen{
    OrthographicCamera camera;
    MyGame game;
    SpriteBatch batch;
    private Assets assets;
    Board board;
    private Enemies enemy;
    private Skin skin;

    public GameScreen(MyGame game) {
        //save the game instance
        this.game = game;

        //create an orthographic camera
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 1280, 720);

        //sprites and assets
        assets = new Assets();
        assets.loadAtlas("pack/imgs.atlas");
        assets.loadAtlas("pack/testpack.txt");

        skin = new Skin();
        skin.addRegions(assets.assets.get("pack/testpack.txt", TextureAtlas.class));

        enemy = new Enemies("snake", 1,skin.getRegion("lizard"));

        batch = new SpriteBatch();

        //setup board
        board = new Board();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        enemy.update(game.batch);
        batch.begin();

        board.drawTiles(batch);
        batch.end();
        camera.update();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void resume() { }

    @Override
    public void pause() { }

    @Override
    public void show() { }

    @Override
    public void hide() { }

    @Override
    public void dispose () {
        assets.dispose();
    }
}