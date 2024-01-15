package org.example.main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int screenWidth = 768;
    public final int screenHeight = 576;

    Thread gameThread;

    // FPS
    int FPS = 60;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));

        this.setBackground(Color.BLACK);

        this.setDoubleBuffered(true);

        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);

        gameThread.start();
    }

    @Override
    // デルタまたは累積型方式
    public void run() {

        double drawInterval = 1000000000 / FPS;

        double delta = 0;

        long lastTime = System.nanoTime();

        long currentTime;

        long timer = 0;

        int drawCount = 0;


        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {

                update();

                repaint();

                delta--;

                drawCount++;
            }

            if (timer >= 1000000000) {

                System.out.println("FPS:" + drawCount);

                drawCount = 0;

                timer = 0;
            }
        }
    }

    public void update() {

    }
}
