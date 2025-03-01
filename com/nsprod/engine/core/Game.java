package com.nsprod.engine.core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class Game extends Canvas implements Runnable
{ 
    private boolean running;
    private Thread thread;
    private Window window;
    
    public Game(int w, int h, String title){ 
        window = new Window(w, h, title, this);
        
        start();
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop()
    {
        try{
            thread.join();
            running = false;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }

            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public abstract void tick();

    public abstract void draw(Graphics g);

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        draw(g);

        g.dispose();
        bs.show();
    }

    public Window getWindow()
    {
        return window;
    }
}
