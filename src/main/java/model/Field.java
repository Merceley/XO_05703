package model;

import exception.WrongCoordinatinatesException;

public class Field {
    private int[][] field;
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getField() {
        return field;
    }

    public Field(int width, int height) {
        this.field = new int[width][height];
        this.height = height;
        this.width = width;
    }
}
