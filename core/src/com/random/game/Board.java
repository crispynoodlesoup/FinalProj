package com.random.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board {
    Tile[][] tiles;

    public Board() {
        //creates a new board of tiles
        tiles = new Tile[9][9];

        int randX;
        int randY;

        //this code initializes all tiles to their respective type
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                //inactive tiles
                if (i - j >= 5 || j - i >= 5)
                    tiles[i][j] = new Tile(0, 0, 0);
                //sand tiles
                else if (tiles[i][j] == null) {
                    tiles[i][j] = new Tile(1, 200, 200);
                    tiles[i][j].scaleBy(0.5f);
                    //0.78 to account for hexagon fitting
                    tiles[i][j].setPos(j * Tile.currWidth*0.785f, i * Tile.currHeight  - j * Tile.currHeight * 0.5f);
                    tiles[i][j].movePos(320,200);
                }
            }
        }
        //oil tiles
        for(int i = 1; i <= 4; i++) {
            //pick 4 random sand tiles to be oil tiles
            randX = (int)(Math.random()*9);
            randY = (int)(Math.random()*9);
            if(tiles[randX][randY].type.getId() == 1) {
                tiles[randX][randY].setType(2);

                //set random tiles around the oil to
                for(int j = -1; j <= 1; j++) {
                    for(int k = -1; k <= 1; k++) {
                        if(randX + j < 9 && randX + j > -1 && randY + k < 9 && randY + k > -1) {
                            if (tiles[randX + j][randY + k].type.getId() == 1 && Math.random() < 0.2) {
                                tiles[randX + j][randY + k].setType(2);
                            }
                        }
                    }
                }
            }
            else
                i--;
        }
        System.out.println(tiles[0][0].sprite.getBoundingRectangle());
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
    public boolean isNextTo() { return true; }

    public void drawTiles(SpriteBatch batch) {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].draw(batch);
            }
        }
    }
}
