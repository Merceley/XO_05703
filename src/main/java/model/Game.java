package model;

import controller.BotController;

public class Game {
    private Field field;
    private Player player1;
    private Player player2;
    //private BotController botController;

    public Game(Player player1, Player player2, int width, int height) {
        this.field = new Field(width,height);
        this.player1 = player1;
        this.player2 = player2;
    }

//    public Game(Player player1,int width, int height){
//        this.field = new Field(width,height);
//        this.player1 = player1;
//    }

    public Field getField() {
        return field;
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }
}
