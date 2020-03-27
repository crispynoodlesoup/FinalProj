package com.random.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Point;
import java.awt.geom.Point2D;

enum TileType {

    //three types of tiles, INACTIVE,
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

    public Sprite sprite() {
        return new Sprite();
    }
}

public class Tile {

    public static final float WIDTH = 56;
    public static final float HEIGHT = 48;
    public static float currWidth;
    public static float currHeight;

    TileType type;
    Sprite sprite;
    Point2D point;

    public Tile(int id, float x, float y) {
        currWidth = WIDTH;
        currHeight = HEIGHT;

        switch (id) {
            case 1:
                type = TileType.SAND;
                break;
            case 2:
                type = TileType.OIL;
                break;
            default:
                type = TileType.INACTIVE;
        }
        point = new Point2D.Float(x, y);
        sprite = type.sprite();
        sprite.setPosition(x, y);
    }

    public void scaleBy(float scale) {
        sprite.scale(scale);
        currWidth = WIDTH + WIDTH*scale;
        currHeight = HEIGHT + HEIGHT*scale;
    }

    public void setPos(float x, float y) {
        sprite.setPosition(x, y);
        point.setLocation(x, y);
    }

    public void movePos(float x, float y) {
        point.setLocation(point.getX() + x, point.getY() + y);
        sprite.setPosition((float)point.getX(), (float)point.getY());
    }

    public void setType(int id) {
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
        sprite.setPosition((float) point.getX(), (float) point.getY());
        sprite.scale((currWidth-WIDTH)/WIDTH);
    }

    public void draw(SpriteBatch batch) {
        if(type.getId() != 0)
            sprite.draw(batch);
    }
}
