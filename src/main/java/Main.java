import view.WindowView;
import model.Field;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int width = 10;
        int height = 10;

        Field field = new Field(width, height);
        WindowView windowView=new WindowView(field);

    }
}
