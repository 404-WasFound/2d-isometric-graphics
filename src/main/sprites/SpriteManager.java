package main.sprites;

import java.util.ArrayList;
import java.util.List;

import main.GamePanel;
import main.Settings;

public class SpriteManager {

    private Settings settings = new Settings();
    public List<Tile> tiles = new ArrayList<Tile>();
    public List<Integer> tilesY = new ArrayList<Integer>();
    GamePanel gp;

    public SpriteManager(GamePanel gp) {

        this.gp = gp;

        tiles.add(new Tile(1, 1, 1, gp, "1"));
        tiles.add(new Tile(1, 1, 2, gp, "1"));

        tiles.add(new Tile(1, 2, 1, gp, "5"));
        tiles.add(new Tile(1, 2, 2, gp, "1"));

        tiles.add(new Tile(5, 1, 2, gp, "1"));
        tiles.add(new Tile(6, 1, 2, gp, "1"));
        tiles.add(new Tile(6, 1, 3, gp, "2"));

        tiles.add(new Tile(9, 1, 6, gp, "3"));

        sortTileY();

    }



    public void sortTileY() {

        int temp = 0;

        tilesY.clear();

        for (Tile tile : tiles) {

            tilesY.add(tile.y);

        }

        for (int i = 0; i < tilesY.size(); i++) {
            
            for (int j = i + 1; j < tilesY.size(); j++) {
                
                if (tilesY.get(i) > tilesY.get(j)) {

                    temp = tilesY.get(i);
                    tilesY.set(i, j);
                    tilesY.set(j, temp);

                }

            }

        }

    }

}
