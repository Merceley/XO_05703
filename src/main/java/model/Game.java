package model;

public class Game {
    private Field field;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2, int width, int height) {
        this.field = new Field(width,height);
        this.player1 = player1;
        this.player2 = player2;
    }
}
