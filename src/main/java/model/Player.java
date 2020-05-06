package model;

public class Player {
    private Figure figure;
    private String name;

    public Player(Figure figure, String name) {
        this.figure = figure;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " - " + figure;
    }
}
