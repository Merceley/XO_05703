package controller;

import model.*;

import java.util.ArrayList;

public class WinnerController {

    private final static int sizewinstep = 5;
    private final static int xsize = 10;
    private final static int ysize = 10;

    public static GameStatus winnerController(Game game) {
        ArrayList<Integer> arrayList = new ArrayList();
        int[][] ourfield = game.getField().getField();
        int one = 1;
        int u = 0;
        //проверка по горизонтали
        for (int k = 0; k < ourfield.length; k++) {
            for (int i = 0; i < ourfield.length - sizewinstep + 1; i++) {
                u = 0;
                for (int j = i; j < i + sizewinstep; j++) {
                    u += ourfield[k][j] * one;
                }
                arrayList.add(u);
            }
        }

        //проверка по вертикали
        for (int k = 0; k < ourfield.length; k++) {
            for (int j = 0; j < ourfield[0].length - sizewinstep + 1; j++) {
                u = 0;
                for (int i = j; i < j + sizewinstep; i++) {
                    u += ourfield[i][k] * one;
                }
                arrayList.add(u);
            }
        }

        //по правильной диагонали
        for (int h = 0; h < ourfield.length - sizewinstep + 1; h++) {
            for (int t = 0; t < ourfield.length - sizewinstep + 1; t++) {
                u = 0;
                for (int i = h; i < h + sizewinstep; i++) {
                    for (int j = t; j < t + sizewinstep; j++) {
                        if (i - h == j - t) {
                            u += ourfield[i][j] * one;
                        }
                    }
                }
                arrayList.add(u);
            }
        }
        //по побочной диагонали
        for (int h = 0; h < ourfield.length - sizewinstep + 1; h++) {
            for (int t = 0; t < ourfield.length - sizewinstep + 1; t++) {
                u = 0;
                for (int i = h; i < h + sizewinstep; i++) {
                    for (int j = t; j < t + sizewinstep; j++) {
                        if (i - h == sizewinstep - j + t - 1) {
                            u += ourfield[i][j] * one;
                        }
                    }
                }
                arrayList.add(u);
            }
        }
        GameStatus gameStatus = GameStatus.INGAME;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == 5 || arrayList.get(i) == -5) {
                gameStatus = GameStatus.END;
            }
        }
        return gameStatus;
    }


    public static int countfigure(Figure figureplayer, int width, int height, int cellx, int celly, Field field) {
        int l, k;
        int figurecounter = 1;
        int[][] ourfield = field.getField();
        l = width + cellx;
        k = height + celly;
        while (l >= 0 && l < xsize && k >= 0 && k < ysize && ourfield[l][k] == Player.returnnumberfigure(figureplayer)) {
            figurecounter++;
            l += cellx;
            k += celly;
        }
        l = width - cellx;
        k = height - celly;
        while (l >= 0 && l < xsize && k >= 0 && k < ysize && ourfield[l][k] == Player.returnnumberfigure(figureplayer)) {
            figurecounter++;
            l -= cellx;
            k -= celly;
        }
        return figurecounter;
    }
}
//реализация без свертки
//    public static int countfigure(Figure figureplayer, int width, int height, int cellx, int celly, Field field) {
//        int l, k;
//        int figurecounter = 1;
//        int[][] ourfield = field.getField();
//        l = width + cellx;
//        k = height + celly;
//        while (l >= 0 && l < xsize && k >= 0 && k < ysize && ourfield[l][k] == Player.returnnumberfigure(figureplayer)) {
//            figurecounter++;
//            l += cellx;
//            k += celly;
//        }
//        l = width - cellx;
//        k = height - celly;
//        while (l >= 0 && l < xsize && k >= 0 && k < ysize && ourfield[l][k] == Player.returnnumberfigure(figureplayer)) {
//            figurecounter++;
//            l -= cellx;
//            k -= celly;
//        }
//        return figurecounter;
//    }
//
//    public static GameStatus wincontroller(Game game, int stepx, int stepy) {
//        GameStatus gameStatus = GameStatus.INGAME;
//        if (countfigure(game.getPlayer1().getFigure(), stepx, stepy, 1, 0, game.getField()) >= sizewinstep ||
//                countfigure(game.getPlayer1().getFigure(), stepx, stepy, 1, 1, game.getField()) >= sizewinstep ||
//                countfigure(game.getPlayer1().getFigure(), stepx, stepy, 0, 1, game.getField()) >= sizewinstep ||
//                countfigure(game.getPlayer1().getFigure(), stepx, stepy, 1, -1, game.getField()) >= sizewinstep
//        ) {
//            gameStatus = GameStatus.END;
//        }
//        if (countfigure(game.getPlayer2().getFigure(), stepx, stepy, 1, 0, game.getField()) >= sizewinstep ||
//                countfigure(game.getPlayer2().getFigure(), stepx, stepy, 1, 1, game.getField()) >= sizewinstep ||
//                countfigure(game.getPlayer2().getFigure(), stepx, stepy, 0, 1, game.getField()) >= sizewinstep ||
//                countfigure(game.getPlayer2().getFigure(), stepx, stepy, 1, -1, game.getField()) >= sizewinstep
//        ) {
//            gameStatus = GameStatus.END;
//        }
//        return gameStatus;
//    }*/


