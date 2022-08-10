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

        tiles.add(new Tile(4, 1, 4, gp, "1"));
        tiles.add(new Tile(6, 1, 4, gp, "1"));
        tiles.add(new Tile(5, 2, 4, gp, "1"));
        tiles.add(new Tile(5, 3, 4, gp, "1"));

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
