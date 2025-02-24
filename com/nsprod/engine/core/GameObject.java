package com.nsprod.engine.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.nsprod.engine.helpers.ID;

public abstract class GameObject {
    protected int x, y, velX, velY, width, height;
    protected ID id;

    public GameObject(ID id)
    {
        this.id = id;
    }

    public GameObject(int x, int y, ID id)
    {
        this.x = x;
        this.y = y;
    }

    public GameObject(int x, int y, int width, int height, ID id)
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
        return new Rectangle(x, y, width, height);
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setVelocity(int velX, int velY)
    {
        this.velX = velX;
        this.velY = velY;
    }

    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public ID getID() {
        return id;
    }
}
