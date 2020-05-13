import controller.MoveController;
import model.Field;
import model.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMain {
    @Test
    public void testSum() {
        int a = 2;
        int b = 3;
        Assertions.assertEquals(5, Main.sum(a, b));
    }

    @Test
    public void testMoveController() {
        int width = 10;
        int height = 10;
        Field field = new Field(width, height);
        Assertions.assertEquals(Figure.X, MoveController.whoseMove(field));

        MoveController.makeMove(4, 3, field);
        Assertions.assertEquals(Figure.O, MoveController.whoseMove(field));

        MoveController.makeMove(4, 3, field);
        Assertions.assertEquals(Figure.O, MoveController.whoseMove(field));
    }

}
