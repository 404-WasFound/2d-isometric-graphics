package main.sprites;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;

import java.awt.MouseInfo;
import java.awt.Point;

public class Mouse {
    
    public int x;
    public int y;

    public int a;
    public int b;
    public int c;
    public int d;

    public Mouse() {

        this.x = 0;
        this.y = 0;

    }



    public void setPos() {

        Point point = MouseInfo.getPointerInfo().getLocation();
        
        this.x = point.x;
        this.y = point.y;

    }

}
