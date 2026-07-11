package com.fragmentsofreality.map;

import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class MapLoader {
    public int[][] grid;
    public int tileSize = 32;
    public List<Rectangle> wallBounds;

    public MapLoader() {
        wallBounds = new ArrayList<>();
        generateBasicMap();
    }

    private void generateBasicMap() {
        grid = new int[20][20];

        for(int y = 0; y < 20; y++) {
            for(int x = 0; x < 20; x++) {
                if(x == 0 || x == 19 || y == 0 || y == 19) {
                    grid[y][x] = 1;
                    wallBounds.add(new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize));
                } else {
                    grid[y][x] = 0;
                }
            }
        }

        grid[5][5] = 1;
        wallBounds.add(new Rectangle(5 * tileSize, 5 * tileSize, tileSize, tileSize));
        grid[5][6] = 1;
        wallBounds.add(new Rectangle(6 * tileSize, 5 * tileSize, tileSize, tileSize));
        grid[10][10] = 1;
        wallBounds.add(new Rectangle(10 * tileSize, 10 * tileSize, tileSize, tileSize));
    }
}
