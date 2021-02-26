package com.codershil.flappychicken.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount ;
    private int frame;

    public Animation(TextureRegion region,int framecount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / framecount;
        for (int i=0 ;i<framecount;i++){
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));
        }
        this.frameCount = framecount;
        maxFrameTime = cycleTime / framecount;
        frame = 0 ;
    }

    public void update(float dt){
        currentFrameTime+= dt;
        if (currentFrameTime> maxFrameTime){
            frame++;
            currentFrameTime = 0 ;
        }
        if (frame>= frameCount){
            frame = 0 ;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
