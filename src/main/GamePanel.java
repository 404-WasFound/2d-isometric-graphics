package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.sprites.SpriteManager;
import main.sprites.Tile;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    public KeyHandler keyHandler = new KeyHandler(this);
    private Settings settings = new Settings();
    public SpriteManager spriteManager = new SpriteManager(this);

    public GamePanel() {

        this.setPreferredSize(new Dimension(settings.SCREEN_WIDTH, settings.SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }



    public void startgameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }



    @Override
    public void run() {

        //* Main game loop

        double drawInterval = 1000000000 / settings.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // UPDATE
                update();

                // DRAW
                //? Uses built-in method to call the other overridden methods
                repaint();

                delta--;

            }

        }

    }


    
    public void update() {

        for (Tile tile : spriteManager.tiles) {

            tile.update();

        }

    }



    //? Default method overridden
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        for (int y = -20; y < 20; y++) {

            for (Tile tile : spriteManager.tiles) {

                if (tile.y == y) {
                    
                    tile.draw(g2);

                }

            }

        }


        g2.dispose();

    }

}
