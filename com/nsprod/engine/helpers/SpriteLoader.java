package com.nsprod.engine.helpers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoader{
    BufferedImage sprite;

    public BufferedImage load(String path) throws IOException
    {
        return ImageIO.read(getClass().getResource(path));
    }
}
