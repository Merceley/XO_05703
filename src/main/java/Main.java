import controller.BotController;
import model.Figure;
import model.Game;
import model.Player;
import view.WindowView;
import model.Field;

import java.awt.*;

import model.Field;
import view.WindowView;


public class Main {
    public static void main(String[] args) {
        int width = 10;
        int height = 10;
//        Field field = new Field(width, height);
        Player player1 = new Player(Figure.X, "Соник");
        Player player2 = new Player(Figure.O, "Фиксик");
        Game game = new Game(player1, player2, width, height);
        //Game game = new Game(player1,width,height);
        BotController botController = new BotController(game);
        WindowView windowView = new WindowView(game);
    }
}
