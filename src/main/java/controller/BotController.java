package controller;

import model.Figure;
import model.Game;
import model.Player;

public class BotController {
    private Player player;
    private Figure figure;
    private String name = "Толик - лузер";

    public BotController(Player player, Game game){
        this.player = player;
        if(player.getFigure()==Figure.O){
            this.figure = Figure.X;
        }else {
            this.figure = Figure.O;
        }
    }

    private void botMove(){

    }


}
