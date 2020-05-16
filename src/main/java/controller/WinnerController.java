package controller;

import model.Field;
import model.Game;
import model.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class WinnerController {
    private int[][] winLines1;
    private int[][] winLines2;
    public static int[][] winLine;
    private Game game;
    public static HashMap<Integer, BufferedImage> lines = new HashMap<>();

    public WinnerController(Game game) {
        this.game = game;
    }

    public Player WhoseWin() {
        //устанавливаем размеры линий
        winLines1 = new int[game.getField().getField().length][game.getField().getField()[0].length];
        winLines2 = new int[game.getField().getField().length][game.getField().getField()[0].length];
        winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];

        //победа по вертикале
        for (int i = 0; i < game.getField().getField().length; i++) {//по строкам
            for (int j = 0; j < 5; j++) {//столбец
                int[] temp = new int[game.getField().getField()[0].length];
                for (int k = j; k < 5 + j; k++) {//двигаем столбец
                    temp[i] += game.getField().getField()[i][k];
                    winLine[i][k] = 1;
                    if (temp[i] == 5) {
                        BufferedImage linevert = null;
                        try {
                            linevert = ImageIO.read(new File("images" + "//" + "linevert.png"));
                            lines.put(1, linevert);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer1();
                    }
                    if (temp[i] == -5) {
                        BufferedImage linevert = null;
                        try {
                            linevert = ImageIO.read(new File("images" + "//" + "linevert.png"));
                            lines.put(1, linevert);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer2();
                    }

                }
                winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];
            }
        }

        //победа по горизонтали
        for (int i = 0; i < game.getField().getField().length; i++) {//по строке
            for (int j = 0; j < 5; j++) {
                int[] temp = new int[game.getField().getField()[0].length];
                for (int k = j; k < 5 + j; k++) {
                    temp[i] += game.getField().getField()[k][i];
                    winLine[k][i] = 1;
                    if (temp[i] == 5) {
                        BufferedImage linegoriz = null;
                        try {
                            linegoriz = ImageIO.read(new File("images" + "//" + "linegoriz.png"));
                            lines.put(1, linegoriz);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer1();
                    }
                    if (temp[i] == -5) {
                        BufferedImage linegoriz = null;
                        try {
                            linegoriz = ImageIO.read(new File("images" + "//" + "linegoriz.png"));
                            lines.put(1, linegoriz);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer2();
                    }
                }
                winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];
            }

        }

        //победа по диагонали сверху вниз
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int temp[][] = new int[7][2];
                for (int k = 0; k < 5; k++) {
                    temp[j][0] += game.getField().getField()[k + j][k + i];
                    temp[j][1] += game.getField().getField()[k + i][k + j];
                    winLines1[k + j][k + i] = 1;
                    winLines2[k + i][k + j] = 1;
                    if (temp[j][0] == 5) {
                        winLine = winLines1;
                        BufferedImage linegoriz = null;
                        try {
                            linegoriz = ImageIO.read(new File("images" + "//" + "linediag1.png"));
                            lines.put(1, linegoriz);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer1();
                    }
                    if (temp[j][1] == 5) {
                        winLine = winLines2;
                        BufferedImage linegoriz = null;
                        try {
                            linegoriz = ImageIO.read(new File("images" + "//" + "linediag1.png"));
                            lines.put(1, linegoriz);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer1();
                    }
                    if (temp[j][0] == -5) {
                        winLine = winLines1;
                        BufferedImage linegoriz = null;
                        try {
                            linegoriz = ImageIO.read(new File("images" + "//" + "linediag1.png"));
                            lines.put(1, linegoriz);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer2();
                    }
                    if (temp[j][1] == -5) {
                        winLine = winLines2;
                        BufferedImage linegoriz = null;
                        try {
                            linegoriz = ImageIO.read(new File("images" + "//" + "linediag1.png"));
                            lines.put(1, linegoriz);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return game.getPlayer2();
                    }
                }
                winLines1 = new int[game.getField().getField().length][game.getField().getField()[0].length];
                winLines2 = new int[game.getField().getField().length][game.getField().getField()[0].length];
            }

        }

        //победа по диагонали c низу вверх/
        for (int i = 5; i < game.getField().getField().length; i++) {
            for (int j = 0; j < game.getField().getField().length; j++) {
                if (game.getField().getField()[i][j] == 1) {
                    if (game.getField().getField()[i - 1][j + 1] == 1) {
                        if (game.getField().getField()[i - 2][j + 2] == 1) {
                            if (game.getField().getField()[i - 3][j + 3] == 1) {
                                if (game.getField().getField()[i - 4][j + 4] == 1) {
                                    for (int k = 0; k <= 4; k++) {
                                        winLine[i - k][j + k] = 1;
                                    }
                                    BufferedImage linegoriz = null;
                                    try {
                                        linegoriz = ImageIO.read(new File("images" + "//" + "linediag2.png"));
                                        lines.put(1, linegoriz);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return game.getPlayer1();
                                }
                            }
                        }
                    }
                }
            }
            winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];
        }
        for (int i = 5; i < game.getField().getField().length; i++) {
            for (int j = 0; j < game.getField().getField().length; j++) {
                if (game.getField().getField()[i][j] == -1) {
                    if (game.getField().getField()[i - 1][j + 1] == -1) {
                        if (game.getField().getField()[i - 2][j + 2] == -1) {
                            if (game.getField().getField()[i - 3][j + 3] == -1) {
                                if (game.getField().getField()[i - 4][j + 4] == -1) {
                                    for (int k = 0; k <= 4; k++) {
                                        winLine[i - k][j + k] = 1;
                                    }
                                    BufferedImage linegoriz = null;
                                    try {
                                        linegoriz = ImageIO.read(new File("images" + "//" + "linediag2.png"));
                                        lines.put(1, linegoriz);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return game.getPlayer2();
                                }
                            }
                        }
                    }
                }
            }
        }
        winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];
        return null;
    }
}
