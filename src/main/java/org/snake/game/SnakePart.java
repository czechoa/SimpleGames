package org.snake.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakePart extends Point {

    private static int size = 30;


    SnakePart(int xPosition, int yPosition) {
        super(xPosition, yPosition, size);
    }

    @Override
    public void paint(GraphicsContext graphics) {
        graphics.setFill(Color.WHITE);
        graphics.fillRect(xPosition, yPosition, size, size);
        graphics.setFill(Color.GRAY);
        graphics.fillRect(xPosition + 1, yPosition + 1, size - 2, size - 2);
    }

    public static void setSize(int size) {
        SnakePart.size = size;
    }

    static int getSnakePartSize() {
        return size;
    }
}
