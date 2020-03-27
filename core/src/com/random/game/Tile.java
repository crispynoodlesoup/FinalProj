package com.random.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

enum TileType {

    INACTIVE(0, false),
    SAND(1, true){
        @Override
        public Sprite sprite() {
            return assets.loadSprite("Sand");
        }
    },
    OIL(2, true) {
        @Override
        public Sprite sprite() {
            return assets.loadSprite("Oil");
        }
    };

    int id;
    boolean active;
    Assets assets;

    TileType(int id, boolean active) {
        assets = new Assets();
        assets.loadAtlas("pack/imgs.atlas");
        this.id = id;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sprite sprite() {
        return new Sprite();
    }
}

public class Tile {

    public static float width;
    public static float height;

    TileType type;
    Sprite sprite;

    public Tile(int id, float scale, float x, float y) {
        switch (id) {
            case 0:
                type = TileType.INACTIVE;
                break;
            case 1:
                type = TileType.SAND;
                break;
            case 2:
                type = TileType.OIL;
                break;
        }
        sprite = type.sprite();
        sprite.setOrigin(x, y);
        sprite.scale(scale);
        sprite.setPosition(x, y);

        width = 56;
        width *= scale;
        height = 48;
        height *= scale;
    }

    public void setPos(float x, float y) {
        sprite.setPosition(x, y);
    }


    public void draw(SpriteBatch batch) {
        if(type.getId() != 0)
            sprite.draw(batch);
    }
}
