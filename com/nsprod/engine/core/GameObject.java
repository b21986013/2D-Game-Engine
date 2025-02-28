package com.nsprod.engine.core;

import java.awt.Graphics;
import java.awt.Rectangle;
 
public abstract class GameObject {
    protected float x, y, velX, velY;
    protected int width, height;
    protected String id;

    public GameObject(String id)
    {
        this.id = id;
    }

    public GameObject(float x, float y, String id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public GameObject(float x, float y, int width, int height, String id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    

    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int) y, width, height);
    }

    public void setPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void setVelocity(float velX, float velY)
    {
        this.velX = velX;
        this.velY = velY;
    }

    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public String getID() {
        return id;
    }
}
