package controller;

import exception.WrongCoordinatinatesException;
import exception.WrongFieldException;
import model.Field;
import model.Figure;

public class MoveController {
    public static Figure whoseMove(Field field) {
        int[][] arr = field.getField();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == 0) {
            return Figure.X;
        } else {
            if (sum == 1) {
                return Figure.O;
            } else throw new WrongFieldException();
        }
    }

    public static void makeMove(int x, int y, Field field) {
        if (x > field.getWidth() || x < 0) {
            throw new WrongCoordinatinatesException();
        }
        if (y > field.getHeight() || y < 0) {
            throw new WrongCoordinatinatesException();
        }
        if (field.getField()[x][y] == 0) {
            Figure current = whoseMove(field);
            switch (current) {
                case O -> field.getField()[x][y] = -1;
                case X -> field.getField()[x][y] = 1;
            }
        }
    }
}
