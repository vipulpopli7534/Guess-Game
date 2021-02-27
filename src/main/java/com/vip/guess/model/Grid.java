package com.vip.guess.model;

public class Grid {
    private final String[][] grid;
    private final int size;

    public Grid(int size) {
        this.grid = new String[size][size];
        this.size = size;
    }

    public Grid(String[][] grid, int size) {
        this.grid = grid;
        this.size = size;
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }
}
