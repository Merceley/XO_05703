import model.Figure;
import model.Game;
import model.Player;
import view.WindowView;
import model.Field;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int width = 10;
        int height = 10;

        Field field = new Field(width, height);
        Player player1 = new Player(Figure.X,"Player One");
        Player player2 = new Player(Figure.O,"Player Two");
        Game game = new Game(player1,player2,width,height);
        WindowView windowView=new WindowView(game);
    }
}
