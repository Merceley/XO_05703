package controller;


import model.Field;
import model.Figure;
import model.Game;
import model.Player;

import java.util.Random;

public class BotController2 {
    boolean b = true;

    public static int randtwomtwo() {
        int p = 0;
        int a = (int) (Math.random() * (100 + 1)) - 50;
        if (a < 0) {
            p = -2;
        } else p = 2;
        return p;
    }

    public static int randthreemthree() {
        int p = 0;
        int a = (int) (Math.random() * (100 + 1)) - 50;
        if (a < 0) {
            p = -3;
        } else p = 3;
        return p;
    }

    public void antiwin(Game game, int stepx, int stepy) {
        Player player1 = new Player(Figure.X, "Player1");
        Player player2 = new Player(Figure.O, "Player2");
        Figure figure1 = player1.getFigure();
        int[][] ourfield = game.getField().getField();
        MoveController.makeMove(stepx, stepy, game.getField());
        if (WinnerController.countfigure(figure1, stepx, stepy, 1, 0, game.getField()) >= 2) {
            if (ourfield[stepx + 2][stepy] == 0 || ourfield[stepx - 2][stepy] == 0) {
                if (stepx + 2 < game.getField().getWidth()) {
                    MoveController.makeMove(stepx + 2, stepy, game.getField());
                } else MoveController.makeMove(stepx - 2, stepy, game.getField());
            }
        }
        if (WinnerController.countfigure(figure1, stepx, stepy, 1, 0, game.getField()) >= 2) {
            if (ourfield[stepx + 2][stepy] == 0 || ourfield[stepx - 2][stepy] == 0) {
                if (stepx - 2 > 0) {
                    MoveController.makeMove(stepx - 2, stepy, game.getField());
                } else MoveController.makeMove(stepx + 2, stepy, game.getField());
            }
        } else if (WinnerController.countfigure(figure1, stepx, stepy, 0, 1, game.getField()) >= 2) {
            if (ourfield[stepx][stepy + 2] == 0 || ourfield[stepx][stepy - 2] == 0) {
                if (stepy + 2 < game.getField().getHeight()) {
                    MoveController.makeMove(stepx, stepy + 2, game.getField());
                } else MoveController.makeMove(stepx, stepy - 2, game.getField());
            }
        }
        if (WinnerController.countfigure(figure1, stepx, stepy, 0, 1, game.getField()) >= 2) {
            if (ourfield[stepx][stepy + 2] == 0 || ourfield[stepx][stepy - 2] == 0) {
                if (stepy - 2 > 0) {
                    MoveController.makeMove(stepx, stepy - 2, game.getField());
                } else MoveController.makeMove(stepx, stepy + 2, game.getField());
            }
        } else if (WinnerController.countfigure(figure1, stepx, stepy, 1, 1, game.getField()) >= 3) {
            if (ourfield[stepx + 3][stepy + 3] == 0 || ourfield[stepx - 3][stepy - 3] == 0) {
                if (stepy - 3 > 0 && stepx - 3 > 0) {
                    MoveController.makeMove(stepx - 3, stepy - 3, game.getField());
                } else MoveController.makeMove(stepx + 3, stepy + 3, game.getField());
            }
        }
        if (WinnerController.countfigure(figure1, stepx, stepy, 1, 1, game.getField()) >= 3) {
            if (ourfield[stepx + 3][stepy + 3] == 0 || ourfield[stepx - 3][stepy - 3] == 0) {
                if (stepy + 3 < game.getField().getHeight() && stepx + 3 < game.getField().getWidth()) {
                    MoveController.makeMove(stepx + 3, stepy + 3, game.getField());
                } else MoveController.makeMove(stepx - 3, stepy - 3, game.getField());
            }
        } else if (WinnerController.countfigure(figure1, stepx, stepy, 1, -1, game.getField()) >= 3) {
            if (ourfield[stepx - 3][stepy + 3] == 0 || ourfield[stepx + 3][stepy - 3] == 0) {
                if (stepy - 3 < game.getField().getHeight() && stepx - 3 > 0) {
                    MoveController.makeMove(stepx - 3, stepy + 3, game.getField());
                } else MoveController.makeMove(stepx + 3, stepy - 3, game.getField());
            }
        }
        if (WinnerController.countfigure(figure1, stepx, stepy, 1, -1, game.getField()) >= 3) {
            if (ourfield[stepx - 3][stepy + 3] == 0 || ourfield[stepx + 3][stepy - 3] == 0) {
                if (stepy - 3 > 0 && stepx - 3 < game.getField().getWidth()) {
                    MoveController.makeMove(stepx + 3, stepy - 3, game.getField());
                } else MoveController.makeMove(stepx - 3, stepy + 3, game.getField());
            }
        } else if (MoveController.sum(game.getField()) == 1 &&
                WinnerController.countfigure(figure1, stepx, stepy, 1, -1, game.getField()) >= 3 &&
                (WinnerController.countfigure(figure1, stepx, stepy, 1, 1, game.getField()) >= 3) &&
                WinnerController.countfigure(figure1, stepx, stepy, 0, 1, game.getField()) >= 2 &&
                WinnerController.countfigure(figure1, stepx, stepy, 1, 0, game.getField()) >= 2) {
            int a = (int) (Math.random() * (100 + 1)) - 50;
            if (a > 10) {
                MoveController.makeMove(stepx + randtwomtwo(), stepy, game.getField());
            }
            if (a <= 10 && a >= -20) {
                MoveController.makeMove(stepx, stepy + randtwomtwo(), game.getField());
            }
            if (a < -20) {
                MoveController.makeMove(stepx + randthreemthree(), stepy + randthreemthree(), game.getField());
            }
        }
        if (MoveController.sum(game.getField()) == 1 &&
                WinnerController.countfigure(figure1, stepx, stepy, 1, -1, game.getField()) < 3 &&
                (WinnerController.countfigure(figure1, stepx, stepy, 1, 1, game.getField()) < 3) &&
                WinnerController.countfigure(figure1, stepx, stepy, 0, 1, game.getField()) < 2 &&
                WinnerController.countfigure(figure1, stepx, stepy, 1, 0, game.getField()) < 2) {
            b = false;
        }

    }

    public void win(Game game, int stepx, int stepy) {
        Player player1 = new Player(Figure.X, "Player1");
        Player player2 = new Player(Figure.O, "Player2");
        Figure figure1 = player1.getFigure();
        Figure figure2 = player2.getFigure();
        int[][] ourfield = game.getField().getField();
        if (b = false) {
            if (WinnerController.countfigure(figure1, stepx, stepy, 1, 0, game.getField()) == 1) {
                if (ourfield[stepx + 2][stepy] == 0 || ourfield[stepx - 2][stepy] == 0) {
                    if (stepx + 2 < game.getField().getWidth()) {
                        MoveController.makeMove(stepx + 1, stepy, game.getField());
                    } else MoveController.makeMove(stepx - 1, stepy, game.getField());
                }
            }
            if (WinnerController.countfigure(figure2, stepx, stepy, 1, 0, game.getField()) >= 2) {
                if (ourfield[stepx + 2][stepy] == 0 || ourfield[stepx - 2][stepy] == 0) {
                    if (stepx + 2 < game.getField().getWidth()) {
                        MoveController.makeMove(stepx + 2, stepy, game.getField());
                    } else MoveController.makeMove(stepx - 2, stepy, game.getField());
                }
            }
            if (WinnerController.countfigure(figure2, stepx, stepy, 1, 0, game.getField()) >= 2) {
                if (ourfield[stepx + 2][stepy] == 0 || ourfield[stepx - 2][stepy] == 0) {
                    if (stepx - 2 > 0) {
                        MoveController.makeMove(stepx - 2, stepy, game.getField());
                    } else MoveController.makeMove(stepx + 2, stepy, game.getField());
                }
            } else if (WinnerController.countfigure(figure2, stepx, stepy, 0, 1, game.getField()) >= 2) {
                if (ourfield[stepx][stepy + 2] == 0 || ourfield[stepx][stepy - 2] == 0) {
                    if (stepy + 2 < game.getField().getHeight()) {
                        MoveController.makeMove(stepx, stepy + 2, game.getField());
                    } else MoveController.makeMove(stepx, stepy - 2, game.getField());
                }
            }
            if (WinnerController.countfigure(figure2, stepx, stepy, 0, 1, game.getField()) >= 2) {
                if (ourfield[stepx][stepy + 2] == 0 || ourfield[stepx][stepy - 2] == 0) {
                    if (stepy - 2 > 0) {
                        MoveController.makeMove(stepx, stepy - 2, game.getField());
                    } else MoveController.makeMove(stepx, stepy + 2, game.getField());
                }
            } else if (WinnerController.countfigure(figure2, stepx, stepy, 1, 1, game.getField()) >= 3) {
                if (ourfield[stepx + 3][stepy + 3] == 0 || ourfield[stepx - 3][stepy - 3] == 0) {
                    if (stepy - 3 > 0 && stepx - 3 > 0) {
                        MoveController.makeMove(stepx - 3, stepy - 3, game.getField());
                    } else MoveController.makeMove(stepx + 3, stepy + 3, game.getField());
                }
            }
            if (WinnerController.countfigure(figure2, stepx, stepy, 1, 1, game.getField()) >= 3) {
                if (ourfield[stepx + 3][stepy + 3] == 0 || ourfield[stepx - 3][stepy - 3] == 0) {
                    if (stepy + 3 < game.getField().getHeight() && stepx + 3 < game.getField().getWidth()) {
                        MoveController.makeMove(stepx + 3, stepy + 3, game.getField());
                    } else MoveController.makeMove(stepx - 3, stepy - 3, game.getField());
                }
            } else if (WinnerController.countfigure(figure2, stepx, stepy, 1, -1, game.getField()) >= 3) {
                if (ourfield[stepx - 3][stepy + 3] == 0 || ourfield[stepx + 3][stepy - 3] == 0) {
                    if (stepy - 3 < game.getField().getHeight() && stepx - 3 > 0) {
                        MoveController.makeMove(stepx - 3, stepy + 3, game.getField());
                    } else MoveController.makeMove(stepx + 3, stepy - 3, game.getField());
                }
            }
            if (WinnerController.countfigure(figure2, stepx, stepy, 1, -1, game.getField()) >= 3) {
                if (ourfield[stepx - 3][stepy + 3] == 0 || ourfield[stepx + 3][stepy - 3] == 0) {
                    if (stepy - 3 > 0 && stepx - 3 < game.getField().getWidth()) {
                        MoveController.makeMove(stepx + 3, stepy - 3, game.getField());
                    } else MoveController.makeMove(stepx - 3, stepy + 3, game.getField());
                }
            } else if (MoveController.sum(game.getField()) == 1 &&
                    WinnerController.countfigure(figure1, stepx, stepy, 1, -1, game.getField()) >= 3 &&
                    (WinnerController.countfigure(figure1, stepx, stepy, 1, 1, game.getField()) >= 3) &&
                    WinnerController.countfigure(figure1, stepx, stepy, 0, 1, game.getField()) >= 2 &&
                    WinnerController.countfigure(figure1, stepx, stepy, 1, 0, game.getField()) >= 2) {
                int a = (int) (Math.random() * (100 + 1)) - 50;
                if (a > 10) {
                    MoveController.makeMove(stepx + randtwomtwo(), stepy, game.getField());
                }
                if (a <= 10 && a >= -20) {
                    MoveController.makeMove(stepx, stepy + randtwomtwo(), game.getField());
                }
                if (a < -20) {
                    MoveController.makeMove(stepx + randthreemthree(), stepy + randthreemthree(), game.getField());
                }
            }
        }
    }


    public void botcontroller(Game game, int stepx, int stepy) {
        antiwin(game, stepx, stepy);
        win(game, stepx, stepy);
    }
}
