package org.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakePart extends Point {
    private static int size = 50;

    SnakePart(int xPosition, int yPosition,int size) {

        super(xPosition, yPosition,size);
    }

    public static int getSizeSnakePart() {
        return size;
    }

    @Override
    public void paint(GraphicsContext graphics){
        graphics.setFill(Color.WHITE);
        graphics.fillRect(xPosition, yPosition,size, size);
        graphics.setFill(Color.GRAY);
        graphics.fillRect(xPosition + 1, yPosition + 1, size - 2, size - 2);
    }

}
