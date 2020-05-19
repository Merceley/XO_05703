import controller.BotController;
import model.Figure;
import model.Game;
import model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMain {

    @Test
    public void testSum() {
        int a = 2;
        int b = 3;
        //Assertions.assertEquals(5, Main.sum(a,b));
    }

    @Test
    public void testBot1() {
        int width = 10;
        int height = 10;

        Player player1 = new Player(Figure.X, "Соник");
        Game game = new Game(player1, width, height);
        BotController botController = new BotController(game);

        int[][] field = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, -1, 0, 0, 0, 0, 0},
                {1, 0, 0, -1, 0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        game.getField().setField(field);
        Assertions.assertEquals(false, BotController.gadid());
        for (int i = 0; i < game.getField().getField().length; i++) {
            for (int j = 0; j < game.getField().getField().length; j++) {
                System.out.print(game.getField().getField()[i][j] + "  ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        field = new int[][]{
                {-1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, -1, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, -1, 0, -1, 0, 0, 0, -1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        game.getField().setField(field);
        Assertions.assertEquals(false, BotController.gadid());
        for (int i = 0; i < game.getField().getField().length; i++) {
            for (int j = 0; j < game.getField().getField().length; j++) {
                System.out.print(game.getField().getField()[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }


    @Test
    public void testBot2() {
        int width = 10;
        int height = 10;

        Player player1 = new Player(Figure.X, "Соник");
        Game game = new Game(player1, width, height);
        BotController botController = new BotController(game);

        int[][] field = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, -1, 0, 0, 0, 0, 0, 1, 0, -1},
                {0, 0, 0, -1, 0, 0, 0, 1, 0, -1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, -1, 0, 0, 0, 0, 0, 0, 0, -1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, -1, 0, 0, -1, 0, 0, 0, 0, -1}
        };
        game.getField().setField(field);
        Assertions.assertEquals(false, BotController.gadid());
        for (int i = 0; i < game.getField().getField().length; i++) {
            for (int j = 0; j < game.getField().getField().length; j++) {
                System.out.print(game.getField().getField()[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }
}
