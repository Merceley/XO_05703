package view;

import controller.WinnerController_Dyutin_Gayazov;
import model.Field;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Animator implements Runnable {
    private Graphics graphics;
    private Graphics screenGraphics;
    private BufferedImage img;
    private int fieldHeight;
    private int fieldWidth;
    private HashMap<Integer, BufferedImage> images = new HashMap<>();
    private int[][] arr;

    public Animator(Graphics screenGraphics, Field field) {
        this.screenGraphics = screenGraphics;
        this.fieldHeight = field.getHeight() * WindowView.CELL_SIZE;
        this.fieldWidth = field.getWidth() * WindowView.CELL_SIZE;
        this.img = new BufferedImage(fieldWidth, fieldHeight, BufferedImage.TYPE_3BYTE_BGR);
        this.graphics = img.getGraphics();
        this.arr = field.getField();
    }

    private void drawAll() {
        if (images.isEmpty()) {
            downloadImages();
        }
        if (!WindowView.stopGame) {
            drawCells();
        }
        else {
            drawImage();
        }
        drawToScreen();
    }


        public void downloadImages() {
        //images = new HashMap<>();
        try {
            String folder = "src//main//resources//images";
            BufferedImage image1 = ImageIO.read(new File(folder + "//" + "fixic.png"));
            images.put(-1, image1);
            BufferedImage image2 = ImageIO.read(new File(folder + "//" + "0.jpg"));
            images.put(0, image2);
            BufferedImage image3 = ImageIO.read(new File(folder + "//" + "соник.png"));
            images.put(1, image3);
//            BufferedImage linevert = ImageIO.read(new File("images" + "//" + "linevert.png"));
//            images.put(2, linevert);
//            BufferedImage linegoriz = ImageIO.read(new File("images" + "//" + "linegoriz.png"));
//            images.put(3, linegoriz);

        } catch (IOException e) {
            System.out.println("ошибка при инициализации картинки");
        }
    }

    public void drawCells() {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    graphics.drawImage(images.get(0),
                            i * WindowView.CELL_SIZE,
                            j * WindowView.CELL_SIZE,
                            WindowView.CELL_SIZE,
                            WindowView.CELL_SIZE,
                            null);
                }
                if (arr[i][j] == 1) {
                    graphics.drawImage(images.get(1),
                            i * WindowView.CELL_SIZE + 5,
                            j * WindowView.CELL_SIZE + 5,
                            WindowView.CELL_SIZE - 10,
                            WindowView.CELL_SIZE - 10,
                            null);
                }
                if (arr[i][j] == -1) {
                    graphics.drawImage(images.get(-1),
                            i * WindowView.CELL_SIZE + 5,
                            j * WindowView.CELL_SIZE + 5,
                            WindowView.CELL_SIZE - 10,
                            WindowView.CELL_SIZE - 10,
                            null);
                }
            }
        }
    }

    private void drawToScreen() {
        screenGraphics.drawImage(img,
                0, 0,
                img.getWidth(), img.getHeight(),
                null);
    }

    public void drawImage() {
        drawCells();
        for (int i = 0; i < WinnerController_Dyutin_Gayazov.winLine.length; i++) {
            for (int j = 0; j < WinnerController_Dyutin_Gayazov.winLine[0].length; j++) {
                if (WinnerController_Dyutin_Gayazov.winLine[i][j] == 1) {
                    graphics.drawImage(WinnerController_Dyutin_Gayazov.lines.get(1),
                            i * WindowView.CELL_SIZE + 2, j * WindowView.CELL_SIZE + 2,
                            WindowView.CELL_SIZE - 4, WindowView.CELL_SIZE - 4,
                            null);
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(33);   // 30 раз в секунда обновляем картинку на экране
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawAll();
        }
    }



}
