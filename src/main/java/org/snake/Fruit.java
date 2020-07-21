package org.snake;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Fruit extends Point {

    private static Random random = new Random();

    Fruit(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    @Override
    public void paint(GraphicsContext graphics) {
        graphics.setFill(Color.YELLOW);
        graphics.fillOval(xPosition,yPosition, size, size);
    }

    public static Fruit makeNewFruit(int boardWidth,int boardHeight){
        int x = random.nextInt(boardWidth - size);
        int y = random.nextInt(boardHeight - size);
        return new Fruit(x,y);
    }
}
