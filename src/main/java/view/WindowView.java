package view;

import controller.BotController;
import controller.MoveController;
import controller.WinnerController_Dyutin_Gayazov;
import exception.WrongCoordinatinatesException;
import model.Game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class WindowView extends JFrame {
    public static final int CELL_SIZE = 70;
    private int[][] arr;
    private MoveController moveController = new MoveController();
    private Game game;
    private WinnerController_Dyutin_Gayazov winnerControllerDyutinGayazov;
    //public static boolean status = false;
    public static boolean stopGame = false;


    public WindowView(Game game) {
        this.setBounds(0, 0, game.getField().getWidth() * CELL_SIZE, game.getField().getHeight() * CELL_SIZE + 20);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowView.EXIT_ON_CLOSE);
        this.arr = game.getField().getField();
        this.winnerControllerDyutinGayazov = new WinnerController_Dyutin_Gayazov(game);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setBackground(Color.WHITE);
        this.add(panel);
        this.setVisible(true);


        Animator animator = new Animator(panel.getGraphics(), game.getField());
        //new Thread(animator).start();


        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / WindowView.CELL_SIZE;//номер ячейки
                int y = e.getY() / WindowView.CELL_SIZE;
                if (x < arr[0].length || y < arr.length) {
                    try {
                        if (!stopGame) {
                            MoveController.makeMove(x, y, game.getField());
                            BotController.gadid();
                        }
                        //if(!stopGame){BotController.gadid();} исправить
                        if (winnerControllerDyutinGayazov.WhoseWin(game) != null) {
                            if (winnerControllerDyutinGayazov.WhoseWin(game).toString().contains(game.getPlayer1().toString())) {
                                //status = true;
                                stopGame = true;
                            }
                            if (winnerControllerDyutinGayazov.WhoseWin(game).toString().contains(game.getPlayer2().toString())) {
                                //status = true;
                                stopGame = true;


                                // Включаем музыку выйгрыша фиксика
                                try {
                                    File soundFile = new File("images" + "//" + "Фиксики1.wav");
                                    AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(ais);
                                    clip.setFramePosition(0);
                                    clip.start();
                                    Thread.sleep(clip.getMicrosecondLength()/1000);
                                    clip.stop();
                                    clip.close();
                                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
                                    exc.printStackTrace();
                                } catch (InterruptedException exc) {}

                            }
                        }
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
        new Thread(animator).start();
    }
}

