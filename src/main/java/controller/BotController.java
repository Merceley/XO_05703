package controller;

import model.Field;
import model.Figure;
import model.Game;
import model.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

public class BotController {
    private static Game game;

    public BotController(Game game) {
        this.game = game;
    }

    public static boolean gadid() {
        int[][] winLine = new int[game.getField().getField().length][game.getField().getField().length];


        //4 фигуры по диагонале с верху вниз
        for (int j = 0; j < 7; j++) {
            for (int k = 0; k < 7; k++) {
                int[][] temp = new int[10][2];
                for (int l = 0; l < 4; l++) {
                    temp[j][0] += game.getField().getField()[l + j][l + k];
                    if (temp[j][0] == -4) {
                        try {
                            if (game.getField().getField()[l + j + 1][k + l + 1] == 0) {
                                MoveController.makeMove(l + j + 1, k + l + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[l + j - 4][k + l - 4] == 0) {
                                MoveController.makeMove(l + j - 4, k + l - 4, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[j][0] == 4) {
                        try {
                            if (game.getField().getField()[l + j + 1][k + l + 1] == 0) {
                                MoveController.makeMove(l + j + 1, k + l + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[l + j - 4][k + l - 4] == 0) {
                                MoveController.makeMove(l + j - 4, k + l - 4, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }


        //4 фигуры по диагонали снизу вверх.
        for (int i = 9; i > 2; i--) {
            for (int j = 0; j < 7; j++) {
                int[] temp = new int[10];
                for (int k = 0; k < 4; k++) {
                    temp[i] += game.getField().getField()[i - k][j + k];
                    if (temp[i] == -4) {
                        try {
                            if (game.getField().getField()[i - k - 1][j + k + 1] == 0) {
                                MoveController.makeMove(i - k - 1, j + k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i - k + 4][j + k - 4] == 0) {
                                MoveController.makeMove(i - k + 4, j + k - 4, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i] == 4) {
                        try {
                            if (game.getField().getField()[i - k - 1][j + k + 1] == 0) {
                                MoveController.makeMove(i - k - 1, j + k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i - k + 4][j + k - 4] == 0) {
                                MoveController.makeMove(i - k + 4, j + k - 4, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }

        }


        //при 4 фигур подряд по вертикале и горизонтале
        for (int i = 0; i < game.getField().getField().length; i++) {//по столбцам
            for (int j = 0; j < 6; j++) {
                int[][] temp = new int[game.getField().getField()[0].length][2];
                for (int k = j; k < 5 + j; k++) {
                    temp[i][0] += game.getField().getField()[k][i];
                    temp[i][1] += game.getField().getField()[i][k];
                    //приоритет по горизонтали
                    if (temp[i][1] == -4) {
                        try {
                            if (game.getField().getField()[i][k - 4] == 0) {
                                MoveController.makeMove(i, k - 4, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i][k + 1] == 0) {
                                MoveController.makeMove(i, k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][0] == -4) {
                        try {
                            if (game.getField().getField()[k - 4][i] == 0) {
                                MoveController.makeMove(k - 4, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[k + 1][i] == 0) {
                                MoveController.makeMove(k + 1, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    //
                    if (temp[i][1] == 4) {
                        try {
                            if (game.getField().getField()[i][k - 4] == 0) {
                                MoveController.makeMove(i, k - 4, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i][k + 1] == 0) {
                                MoveController.makeMove(i, k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][0] == 4) {
                        try {
                            if (game.getField().getField()[k - 4][i] == 0) {
                                MoveController.makeMove(k - 4, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[k + 1][i] == 0) {
                                MoveController.makeMove(k + 1, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }

                }
            }
        }


        //3 фигуры по диагонале с верху вниз
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                int[][] temp = new int[10][2];
                for (int l = 0; l < 3; l++) {
                    temp[j][0] += game.getField().getField()[l + j][l + k];
                    if (temp[j][0] == -3) {
                        try {
                            if (game.getField().getField()[l + j + 1][k + l + 1] == 0) {
                                MoveController.makeMove(l + j + 1, k + l + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[l + j - 3][k + l - 3] == 0) {
                                MoveController.makeMove(l + j - 3, k + l - 3, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[j][0] == 3) {
                        try {
                            if (game.getField().getField()[l + j + 1][k + l + 1] == 0) {
                                MoveController.makeMove(l + j + 1, k + l + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[l + j - 3][k + l - 3] == 0) {
                                MoveController.makeMove(l + j - 3, k + l - 3, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }


        //3 фигуры по диагонале снизу вверх
        for (int i = 9; i > 1; i--) {
            for (int j = 0; j < 8; j++) {
                int[] temp = new int[10];
                for (int k = 0; k < 3; k++) {
                    temp[i] += game.getField().getField()[i - k][j + k];
                    if (temp[i] == -3) {
                        try {
                            if (game.getField().getField()[i - k - 1][j + k + 1] == 0) {
                                MoveController.makeMove(i - k - 1, j + k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i - k + 3][j + k - 3] == 0) {
                                MoveController.makeMove(i - k + 3, j + k - 3, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i] == 3) {
                        try {
                            if (game.getField().getField()[i - k - 1][j + k + 1] == 0) {
                                MoveController.makeMove(i - k - 1, j + k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i - k + 3][j + k - 3] == 0) {
                                MoveController.makeMove(i - k + 3, j + k - 3, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }

        }


        //при 3 фигур подряд по вертикале и горизонтале
        for (int i = 0; i < game.getField().getField().length; i++) {//по столбцам
            for (int j = 0; j < 7; j++) {
                int[][] temp = new int[game.getField().getField()[0].length][2];
                for (int k = j; k < 4 + j; k++) {
                    temp[i][0] += game.getField().getField()[k][i];
                    temp[i][1] += game.getField().getField()[i][k];
                    //приоритет по горизонтали
                    if (temp[i][1] == -3) {
                        try {
                            if (game.getField().getField()[i][k - 3] == 0) {
                                MoveController.makeMove(i, k - 3, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i][k + 1] == 0) {
                                MoveController.makeMove(i, k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][0] == -3) {
                        try {
                            if (game.getField().getField()[k - 3][i] == 0) {
                                MoveController.makeMove(k - 3, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[k + 1][i] == 0) {
                                MoveController.makeMove(k + 1, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][1] == 3) {
                        try {
                            if (game.getField().getField()[i][k - 3] == 0) {
                                MoveController.makeMove(i, k - 3, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i][k + 1] == 0) {
                                MoveController.makeMove(i, k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][0] == 3) {
                        try {
                            if (game.getField().getField()[k - 3][i] == 0) {
                                MoveController.makeMove(k - 3, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[k + 1][i] == 0) {
                                MoveController.makeMove(k + 1, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }

                }
            }
        }


        //2 фигуры по диагонале с верху вниз
        for (int j = 0; j < 9; j++) {
            for (int k = 0; k < 9; k++) {
                int[][] temp = new int[10][2];
                for (int l = 0; l < 2; l++) {
                    temp[j][0] += game.getField().getField()[l + j][l + k];
                    if (temp[j][0] == -2) {
                        try {
                            if (game.getField().getField()[l + j + 1][k + l + 1] == 0) {
                                MoveController.makeMove(l + j + 1, k + l + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[l + j - 2][k + l - 2] == 0) {
                                MoveController.makeMove(l + j - 2, k + l - 2, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[j][0] == 2) {
                        try {
                            if (game.getField().getField()[l + j + 1][k + l + 1] == 0) {
                                MoveController.makeMove(l + j + 1, k + l + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[l + j - 2][k + l - 2] == 0) {
                                MoveController.makeMove(l + j - 2, k + l - 2, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }


        //2 фигуры по диагонале снизу вверх
        for (int i = 9; i > 0; i--) {
            for (int j = 0; j < 9; j++) {
                int[] temp = new int[10];
                for (int k = 0; k < 2; k++) {
                    temp[i] += game.getField().getField()[i - k][j + k];
                    if (temp[i] == -2) {
                        try {
                            if (game.getField().getField()[i - k - 1][j + k + 1] == 0) {
                                MoveController.makeMove(i - k - 1, j + k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i - k + 2][j + k - 2] == 0) {
                                MoveController.makeMove(i - k + 2, j + k - 2, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i] == 2) {
                        try {
                            if (game.getField().getField()[i - k - 1][j + k + 1] == 0) {
                                MoveController.makeMove(i - k - 1, j + k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i - k + 2][j + k - 2] == 0) {
                                MoveController.makeMove(i - k + 2, j + k - 2, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }

        }


        //при 2 фигур подряд по вертикале и горизонтале
        for (int i = 0; i < game.getField().getField().length; i++) {//по столбцам
            for (int j = 0; j < 8; j++) {
                int[][] temp = new int[game.getField().getField()[0].length][2];
                for (int k = j; k < 3 + j; k++) {
                    temp[i][0] += game.getField().getField()[k][i];
                    temp[i][1] += game.getField().getField()[i][k];
                    //приоритет по горизонтали
                    if (temp[i][1] == -2) {
                        try {
                            if (game.getField().getField()[i][k - 2] == 0) {
                                MoveController.makeMove(i, k - 2, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i][k + 1] == 0) {
                                MoveController.makeMove(i, k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][0] == -2) {
                        try {
                            if (game.getField().getField()[k - 2][i] == 0) {
                                MoveController.makeMove(k - 2, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[k + 1][i] == 0) {
                                MoveController.makeMove(k + 1, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][1] == 2) {
                        try {
                            if (game.getField().getField()[i][k - 2] == 0) {
                                MoveController.makeMove(i, k - 2, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[i][k + 1] == 0) {
                                MoveController.makeMove(i, k + 1, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (temp[i][0] == 2) {
                        try {
                            if (game.getField().getField()[k - 2][i] == 0) {
                                MoveController.makeMove(k - 2, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                        try {
                            if (game.getField().getField()[k + 1][i] == 0) {
                                MoveController.makeMove(k + 1, i, game.getField());
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }

                }
            }
        }


        //1 фигура
//        for (int i = 0; i < game.getField().getField().length; i++) {
//            for (int j = 0; j < game.getField().getField().length - 1; j++) {
//                int[] temp = new int[game.getField().getField()[0].length];
//                for (int k = j; k < 1 + j; k++) {
//                    temp[i] += game.getField().getField()[i][k];
//
//                    if (temp[i] == -1) {
//                        try {
//                            if (game.getField().getField()[i][k - 1] == 0) {
//                                MoveController.makeMove(i, k - 1, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                        try {
//                            if (game.getField().getField()[i][k + 1] == 0) {
//                                MoveController.makeMove(i, k + 1, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                        try {
//                            if (game.getField().getField()[i - 1][k] == 0) {
//                                MoveController.makeMove(i - 1, k, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                        try {
//                            if (game.getField().getField()[i + 1][k] == 0) {
//                                MoveController.makeMove(i + 1, k, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                    }
//                    if (temp[i] == 1) {
//                        try {
//                            if (game.getField().getField()[i][k - 1] == 0) {
//                                MoveController.makeMove(i, k - 1, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                        try {
//                            if (game.getField().getField()[i][k + 1] == 0) {
//                                MoveController.makeMove(i, k + 1, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                        try {
//                            if (game.getField().getField()[i - 1][k] == 0) {
//                                MoveController.makeMove(i - 1, k, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                        try {
//                            if (game.getField().getField()[i + 1][k] == 0) {
//                                MoveController.makeMove(i + 1, k, game.getField());
//                                return false;
//                            }
//                        } catch (Exception e) {
//                        }
//                    }
//                }
//            }
//        }


        // ход

        //1 фигура

        //1 фигура
        for (int i = 0; i < game.getField().getField().length; i++) {
            int[] temp = new int[10];
            for (int j = 0; j < game.getField().getField().length; j++) {
                temp[i] += game.getField().getField()[i][j];
                if (temp[i] == -1) {
                    try {
                        if (game.getField().getField()[i][j - 1] == 0) {
                            MoveController.makeMove(i, j - 1, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (game.getField().getField()[i][j + 1] == 0) {
                            MoveController.makeMove(i, j + 1, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (game.getField().getField()[i - 1][j] == 0) {
                            MoveController.makeMove(i - 1, j, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (game.getField().getField()[i + 1][j] == 0) {
                            MoveController.makeMove(i + 1, j, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                }
                if (temp[i] == 1) {
                    try {
                        if (game.getField().getField()[i][j - 1] == 0) {
                            MoveController.makeMove(i, j - 1, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (game.getField().getField()[i][j + 1] == 0) {
                            MoveController.makeMove(i, j + 1, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (game.getField().getField()[i - 1][j] == 0) {
                            MoveController.makeMove(i - 1, j, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (game.getField().getField()[i + 1][j] == 0) {
                            MoveController.makeMove(i + 1, j, game.getField());
                            return false;
                        }
                    } catch (Exception e) {
                    }
                    temp = new int[10];
                }
            }

        }


        Random random = new Random();
        int y = 0;
        for (int i = 0; i < game.getField().getField().length; i++) {
            for (int j = 0; j < game.getField().getField().length; j++) {
                y += game.getField().getField()[i][j];
            }
        }
        if (y == 0) {
            MoveController.makeMove(random.nextInt(9),
                    random.nextInt(9), game.getField());
            return false;
        }


        return false;
    }

}

