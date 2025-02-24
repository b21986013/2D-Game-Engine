package com.nsprod.engine.core;

import java.awt.Graphics;
import java.util.LinkedList;

public final class Handler {
    private static LinkedList<GameObject> gameObjects = new LinkedList<>();

    private Handler()
    {

    }

    public static void tick(){
        for(int i = 0; i < gameObjects.size(); i++)
        {
            gameObjects.get(i).tick();
        }
    }

    public static void render(Graphics g)
    {
        for(int i = 0; i < gameObjects.size(); i++)
        {
            gameObjects.get(i).render(g);
        }
    }

    public static void addGameObject(GameObject go)
    {
       gameObjects.add(go);
    }

    public static void removeGameObject(GameObject go)
    {
        gameObjects.remove(go);
    }

    public static LinkedList<GameObject> getGameObjects()
    {
        return gameObjects;
    }
 
}
