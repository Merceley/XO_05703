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
    int[] arr;
    public static int[][] winLine;
    private Game game;
    public static HashMap<Integer, BufferedImage> lines = new HashMap<>();

    public WinnerController(Game game) {
        this.game = game;
    }


    public Player WhoseWin() {
        /*if (game.getField().getField().length < 10) {
            arr = new int[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
        } else {
            arr = new int[5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
        }*/
        winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];
        //Победа по вертикали.
        for (int i = 0; i < game.getField().getField().length; i++) {
            for (int j = 0; j < 5; j++) {
                int[] temp = new int[game.getField().getField()[0].length];
                for (int k = j; k < 5 + j; k++) {
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
        for (int i = 0; i < game.getField().getField().length; i++) {
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
        //победа по диагонали сверху вниз.
        for (int i = 0; i <= 5; i++) {
            int[] temp = new int[game.getField().getField()[0].length];
            for (int k = i; k <= 5; k++) {
                temp[i] += game.getField().getField()[k][k];
                winLine[k][k] = 1;
                if (temp[i] == 5) {
                    BufferedImage linegoriz = null;
                    try {
                        linegoriz = ImageIO.read(new File("images" + "//" + "linediag1.png"));
                        lines.put(1, linegoriz);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return game.getPlayer1();
                }
                if (temp[i] == -5) {
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
            winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];

        }
        //победа по диагонали снизу вверх.
        for (int i = game.getField().getField().length - 5; i >= 0; i--) {
            int[] temp = new int[game.getField().getField()[0].length];
            for (int k = i; k >= 5 + i; k--) {
                temp[i] += game.getField().getField()[k][k];
                winLine[k][k] = 1;
                if (temp[i] == 5) {
                    BufferedImage linegoriz = null;
                    try {
                        linegoriz = ImageIO.read(new File("images" + "//" + "linediag2.png"));
                        lines.put(1, linegoriz);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return game.getPlayer1();
                }
                if (temp[i] == -5) {
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
            winLine = new int[game.getField().getField().length][game.getField().getField()[0].length];

        }

        return null;
    }
}
