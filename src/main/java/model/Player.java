package model;

public class Player {
    private Figure figure;
    private String name;

    public Player(Figure figure, String name) {
        this.figure = figure;
        this.name = name;
    }

    public static int returnnumberfigure(Figure figure) {
        int k = 0;
        if (figure == Figure.X) {
            k = 1;
        }
        if (figure == Figure.O) {
            k = -1;
        }
        return k;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return name + " - " + figure;
    }
}
