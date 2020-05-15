package controller;

import model.Field;
import model.Game;
import model.Player;

public class WinnerController {
    int[] arr;
    public static int winLineX = 0;
    public static int[] winLineY = new int[2];
    private Game game;

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

        for (int i = 0; i < game.getField().getField().length; i++) {
            for (int j = 0; j < 5; j++) {
                int[] temp = new int[game.getField().getField()[0].length];
                for (int k = 0 + j; k < 5 + j; k++) {
                    temp[i] += game.getField().getField()[i][k];
                    if (temp[i] == 5) {
                        winLineX = i;
                        winLineY[0] = j;
                        winLineY[1] = k;
                        return game.getPlayer1();
                    }
                    if (temp[i] == -5) {
                        winLineX = i;
                        winLineY[0] = j;
                        winLineY[1] = k;
                        return game.getPlayer2();
                    }
                }
            }

        }
        return null;
    }
}
