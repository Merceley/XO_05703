package controller;

import exception.WrongCoordinatinatesException;
import exception.WrongFieldException;
import model.Field;
import model.Figure;

public class MoveController {
    private static int[][] arr;

    public static Figure whoseMove(Field field) {
        arr = field.getField();
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
        arr = field.getField();
        if (x > field.getWidth() || x < 0) {
            throw new WrongCoordinatinatesException();
        }
        if (y > field.getHeight() || y < 0) {
            throw new WrongCoordinatinatesException();
        }
        if (field.getField()[x][y] == 0) {
            Figure current = whoseMove(field);
            switch (current) {
                case O:
                    arr[x][y] = -1;
                    field.setField(arr);
                    break;
                case X:
                    arr[x][y] = 1;
                    field.setField(arr);
                    break;
                default:
                    break;
            }
        }
    }

    public static int sum(Field field) {
        int[][] arr = field.getField();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
