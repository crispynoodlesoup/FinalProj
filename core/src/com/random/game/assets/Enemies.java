package com.random.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemies {
    float x;
    float y;

    private static final int FRAME_COLS = 1; //Change once find frame
    private static final int FRAME_ROWS = 4;

    public static final int IDLE = 0;
    public static final int ATTACK = 1;
    private int currentAnimation;

    private float stateTime = 0;

    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> attackAnimation;

    private TextureRegion[] idleFrames;
    private TextureRegion[] attackFrames;

    private TextureRegion currentFrame;
    private Animation [] animations;

    public Enemies(String whatType, int numberOf, TextureRegion textureRegionEnemies){
        if(whatType.equals("snake")){
            //index through animations for snake idle
            TextureRegion[][] tmp = textureRegionEnemies.split(100, 100); //Change once find format of pack
            idleFrames = new TextureRegion[4];
            int index = 0;
            for (int i = 0; i < FRAME_ROWS ; i++){
                idleFrames[index++] = tmp[0][i];
            }
            idleAnimation = new Animation<>(0.05f, idleFrames);
            idleAnimation.setPlayMode(Animation.PlayMode.LOOP);

            //animations inside of an array
            animations = new Animation[1];
            animations[0] = idleAnimation;

            setCurrentAnimation(IDLE);

            //index through animations for snake attack
            tmp = textureRegionEnemies.split(100, 100);
            attackFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
            index = 0;
            for (int i = 0; i < FRAME_ROWS; i++) {
                attackFrames[index++] = tmp[0][i];
            }
            attackAnimation = new Animation(0.075f, attackFrames);
            attackAnimation.setPlayMode(Animation.PlayMode.LOOP);

            // Array of Animations
            animations = new Animation[2];
            animations[0] = idleAnimation;
            animations[1] = attackAnimation;

            // Initial currentAnimation
            setCurrentAnimation(IDLE);

        }else if(whatType.equals("lizard")){
            //index through animations for lizard idle
            TextureRegion[][] tmp = textureRegionEnemies.split(100, 100); //Change once find format of pack
            idleFrames = new TextureRegion[4];
            int index = 0;
            for (int i = 0; i < FRAME_ROWS ; i++){
                idleFrames[index++] = tmp[0][i];
            }
            idleAnimation = new Animation<>(0.05f, idleFrames);
            idleAnimation.setPlayMode(Animation.PlayMode.LOOP);

            //animations inside of an array
            animations = new Animation[1];
            animations[0] = idleAnimation;

            setCurrentAnimation(IDLE);

            //index through animations for lizard attack
            tmp = textureRegionEnemies.split(100, 100);
            attackFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
            index = 0;
            for (int i = 0; i < FRAME_ROWS; i++) {
                attackFrames[index++] = tmp[0][i];
            }
            attackAnimation = new Animation(0.075f, attackFrames);
            attackAnimation.setPlayMode(Animation.PlayMode.LOOP);

            // Array of Animations
            animations = new Animation[2];
            animations[0] = idleAnimation;
            animations[1] = attackAnimation;

            // Initial currentAnimation
            setCurrentAnimation(IDLE);

        }else if(whatType.equals("worm")){
            //index through animations for worm idle
            TextureRegion[][] tmp = textureRegionEnemies.split(100, 100); //Change once find format of pack
            idleFrames = new TextureRegion[4];
            int index = 0;
            for (int i = 0; i < FRAME_ROWS ; i++){
                idleFrames[index++] = tmp[0][i];
            }
            idleAnimation = new Animation<>(0.05f, idleFrames);
            idleAnimation.setPlayMode(Animation.PlayMode.LOOP);

            //animations inside of an array
            animations = new Animation[1];
            animations[0] = idleAnimation;

            setCurrentAnimation(IDLE);
            //index through animations for worm attack
            tmp = textureRegionEnemies.split(100, 100);
            attackFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
            index = 0;
            for (int i = 0; i < FRAME_ROWS; i++) {
                attackFrames[index++] = tmp[0][i];
            }
            attackAnimation = new Animation(0.075f, attackFrames);
            attackAnimation.setPlayMode(Animation.PlayMode.LOOP);

            // Array of Animations
            animations = new Animation[2];
            animations[0] = idleAnimation;
            animations[1] = attackAnimation;

            // Initial currentAnimation
            setCurrentAnimation(IDLE);
        }
    }

    public void setCurrentAnimation(int currentAnimation){
        this.currentAnimation = currentAnimation;
        stateTime = 0;
    }

    public int getCurrentAnimation(){
        return currentAnimation;
    }

    public void update(SpriteBatch batch){
        stateTime += Gdx.graphics.getDeltaTime();

        currentFrame = (TextureRegion) animations[currentAnimation].getKeyFrame(stateTime, true);

        //put if statements for turn movement here

        batch.begin();
        batch.draw(currentFrame, x, y);
        batch.end();
    }
}
