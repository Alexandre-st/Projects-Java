package game;

import java.util.Arrays;

public class Map {
    private static final int[][] MAP_TEMPLATE_DEFAULT = {
            { 2, 0, 1, 1, 0, 0, 1, 1 },
            { 1, 0, 1, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 1, 0, 1, 0, 1 },
            { 1, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 1, 1, 0, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 1, 0, 1, 0, 0 },
            { 1, 1, 3, 0, 0, 1, 1, 0 },
            { 0, 1, 1, 0, 1, 1, 1, 0 },
            { 1, 0, 1, 0, 0, 0, 1, 0 },
            { 1, 0, 1, 1, 0, 1, 0, 0 },
            { 1, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 1, 1, 0, 1, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 1, 1 },
            { 1, 0, 1, 1, 1, 0, 0, 1 },
            { 1, 1, 0, 0, 0, 1, 0, 0 },
    };

    private int[][] map;

    public Map() {
        // Copier la matrice de modèle pour éviter les modifications indésirables
        this.map = new int[MAP_TEMPLATE_DEFAULT.length][];
        for (int i = 0; i < MAP_TEMPLATE_DEFAULT.length; i++) {
            this.map[i] = Arrays.copyOf(MAP_TEMPLATE_DEFAULT[i],
                    MAP_TEMPLATE_DEFAULT[i].length);
        }
    }

    public int[][] getMap() {
        int rows = this.map.length;
        int cols = this.map[0].length;
        int[][] mapCopy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            mapCopy[i] = Arrays.copyOf(this.map[i], cols);
        }
        return mapCopy;
    }

    public boolean isWall(int row, int col) {
        return map[row][col] == 1;
    }
}
