package view;

import model.Field;

import javax.swing.*;
import java.awt.*;

public class WindowView extends JFrame {
    final private int CELL_SIZE = 70;


    public WindowView(Field field) {
        this.setBounds(100, 100, field.getWidth() * CELL_SIZE,
                field.getHeight() * CELL_SIZE);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


}
