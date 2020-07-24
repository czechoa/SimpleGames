package org.snake.game;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Fruit extends Point {

    private static int size = 10;

    private static Random random = new Random();

    Fruit(int xPosition, int yPosition) {
        super(xPosition, yPosition,size);
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

    public static void setSize(int size) {
        Fruit.size = size;
    }

    public static int getFruitSize() {
        return size;
    }
}
