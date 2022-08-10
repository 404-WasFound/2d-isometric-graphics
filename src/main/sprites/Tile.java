package main.sprites;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import main.GamePanel;
import main.Settings;
import main.utils.Utils;

public class Tile {
    
    public int x;
    public int y;
    public int z;
    public int i;
    public int l;
    public int j;
    public BufferedImage image;

    private boolean movedLeft;
    private boolean movedRight;
    private boolean movedUp;
    private boolean movedDown;

    private Settings settings = new Settings();
    private ImageLoader imageLoader = new ImageLoader();
    private Utils utils = new Utils();
    GamePanel gp;

    public Tile(int x, int y, int z, GamePanel gp, String type) {

        this.gp = gp;

        this.x = x;
        this.y = y;
        this.z = z;
        this.i = 0;
        this.l = 0;
        this.j = 0;

        this.movedLeft = false;
        this.movedRight = false;
        this.movedUp = false;
        this.movedDown = false;

        this.image = imageLoader.getImage(type);

    }


    public void getLeftInput() {

        if (gp.keyHandler.leftPressed && !this.movedLeft) {

            this.x -= 1;
            this.z += 1;
            this.movedLeft = true;

        }

        if (!gp.keyHandler.leftPressed && this.movedLeft) {

            this.movedLeft = false;

        }

    }



    public void getRightInput() {

        if (gp.keyHandler.rightPressed && !this.movedRight) {

            this.x += 1;
            this.z -= 1;
            this.movedRight = true;

        }

        if (!gp.keyHandler.rightPressed && this.movedRight) {

            this.movedRight = false;

        }

    }



    public void getUpInput() {

        if (gp.keyHandler.upPressed && !this.movedUp) {

            this.y -= 1;
            this.movedUp = true;

        }

        if (!gp.keyHandler.upPressed && this.movedUp) {

            this.movedUp = false;

        }

    }



    public void getDownInput() {

        if (gp.keyHandler.downPressed && !this.movedDown) {

            this.y += 1;
            this.movedDown = true;

        }

        if (!gp.keyHandler.downPressed && this.movedDown) {

            this.movedDown = false;

        }

    }


    public void update() {

        this.getLeftInput();
        this.getRightInput();
        this.getUpInput();
        this.getDownInput();

    }



    public void draw(Graphics2D g2) {

        int[] pos = utils.getIJPos(this.x, this.y, this.z);
        this.i = pos[0] + (settings.SCREEN_WIDTH / 2) - (settings.TILE_SIZE / 2);
        this.l = pos[1];
        this.j = pos[2];

        g2.drawImage(this.image, this.i, this.l, settings.TILE_SIZE, settings.TILE_SIZE, null);

    }

}
