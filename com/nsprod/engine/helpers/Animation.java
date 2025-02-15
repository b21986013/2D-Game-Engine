package com.nsprod.engine.helpers;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Animation 
{
    private int speed;
    private int frames;

    private int index = 0; 
    private int count = 0;  

    private BufferedImage[] sprites;
    private BufferedImage currentSprite; 
    
    public Animation(int speed, BufferedImage... args){
        this.speed = speed;
        this.sprites = new BufferedImage[args.length];
        for(int i = 0; i < args.length; i++)
        {
            sprites[i] = args[i];   
        }

        frames = args.length;
    }

    public void runAnimation()
    {
        index++;
        if(index > speed)
        {
            index = 0;
            nextFrame();
        }
    }

    private void nextFrame()
    {
        for(int i = 0; i < frames; i++)
        {
            if(count == i)
                currentSprite = sprites[i];
        }

        count++;

        if(count > frames)
            count = 0;
    }

    public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY)
    {
        g.drawImage(currentSprite, x, y, scaleX, scaleY, null);
    }
    
}
