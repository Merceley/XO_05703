package view;


import controller.MoveController;
import exception.WrongCoordinatinatesException;
import model.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowView extends JFrame {
    public static final int CELL_SIZE = 70;
    private int[][] arr;
    private MoveController moveController = new MoveController();

    public WindowView(Field field) {
        this.setBounds(0, 0, field.getWidth() * CELL_SIZE, field.getHeight() * CELL_SIZE + 20);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowView.EXIT_ON_CLOSE);
        this.arr = field.getField();


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setBackground(Color.black);
        this.add(panel);
        this.setVisible(true);


        Animator animator = new Animator(panel.getGraphics(), field);
        new Thread(animator).start();

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / WindowView.CELL_SIZE;//номер ячейки
                int y = e.getY() / WindowView.CELL_SIZE - 1;
                if (x < arr[0].length || y < arr.length) {
                    try {
                        moveController.makeMove(x, y, field);
                    } catch (WrongCoordinatinatesException ee) {

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}

