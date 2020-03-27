package com.random.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    TextureAtlas atlas;
    public AssetManager assets;
    public AssetManager manager;


    public Assets() { assets = new AssetManager(); }

    public void loadAtlas(String atlasFileName) {
        assets.load(atlasFileName, TextureAtlas.class);
        assets.finishLoading();

        atlas = assets.get(atlasFileName);
    }

    public Sprite loadSprite(String region) {
        Sprite sprite = new Sprite(atlas.findRegion(region));
        return sprite;
    }

    public void dispose() {
        assets.dispose();
        atlas.dispose();
    }
}
