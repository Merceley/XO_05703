import model.Field;
import view.WindowView;

public class Main {
    public static void main(String[] args) {
        int width = 10;
        int height = 10;
        Field field = new Field(width, height);
        WindowView windowView=new WindowView(field);

    }

    public static int sum(int a, int b) {
        return a + b;
    }

}
