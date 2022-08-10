package main.utils;

import main.Settings;

public class Utils {

    private Settings settings = new Settings();
    
    public int[] getIJPos(int x, int y, int z) {

        Double dNewXi = x * 0.5 * settings.TILE_SIZE;
        Double dNewZi = z * -0.5 * settings.TILE_SIZE;
        Double dNewi = dNewXi + dNewZi;

        int i = dNewi.intValue();


        Double dNewXj = x * 0.25 * settings.TILE_SIZE;
        Double dNewZj = z * 0.25 * settings.TILE_SIZE;
        Double dNewj = dNewXj + dNewZj;

        int j = dNewj.intValue();

        int l = j - (y * (settings.TILE_SIZE / 2));

        return new int[] {i, l, j};

    }

}
