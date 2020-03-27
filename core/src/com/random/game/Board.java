package com.random.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board {
    Tile[][] tiles;

    public Board() {
        tiles = new Tile[9][9];
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(i - j >= 5 || j - i >= 5)
                    tiles[i][j] = new Tile(0, 1, 0,0);
                else if(tiles[i][j] == null) {
                    tiles[i][j] = new Tile(1, 0.5f, 0,0);
                    tiles[i][j].setPos(i* Tile.width*2.4f + 300,(j+2.5f)* Tile.height*3f - i* Tile.height*1.5f);
                }
            }
        }
    }

    public void generate() {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                if(tiles[i][j].type.getId() != 0) {

                }
            }
        }
    }

    //determines if tiles are next to each other
    public boolean isNextTo() { return false; }

    public void drawTiles(SpriteBatch batch) {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].draw(batch);
            }
        }
    }
}
