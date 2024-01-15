package racket;

import main.GamePanel;

import java.awt.*;

public class Racket {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 10;

    private final int centerPos;
    private final GamePanel gamePanel;

    public Racket(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        centerPos = gamePanel.screenWidth / 2;
    }

    public void draw(Graphics g2) {

        g2.setColor(Color.WHITE);

        g2.fillRect(centerPos - WIDTH / 2, gamePanel.screenHeight - HEIGHT,
                WIDTH, HEIGHT);
    }
}
