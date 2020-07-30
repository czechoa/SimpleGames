package org.snake.game;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Fruit extends Point {

    private static int size = 10;

    private static final Random random = new Random();

    Fruit(int xPosition, int yPosition) {
        super(xPosition, yPosition, size);
    }

    @Override
    public void paint(GraphicsContext graphics) {
        graphics.setFill(Color.YELLOW);
        graphics.fillOval(xPosition, yPosition, size, size);
    }

    static Fruit makeNewFruit(int boardWidth, int boardHeight) {
        int size = Math.max(Fruit.size, SnakePart.getSnakePartSize());
        int x = random.nextInt(boardWidth - 2 * size) + size;
        int y = random.nextInt(boardHeight - 2 * size) + size;
        return new Fruit(x, y);
    }

    public static void setSize(int size) {
        Fruit.size = size;
    }

}
