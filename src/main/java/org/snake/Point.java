package org.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point {
    private int xPosition;
    private  int yPosition;
    private int size = 10;

    Point(int xPosition,int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public void paint(GraphicsContext graphics){
        graphics.setFill(Color.WHITE);
        graphics.fillRect(xPosition, yPosition,size, size);
        graphics.setFill(Color.GRAY);
        graphics.fillRect(xPosition + 1, yPosition + 1, size - 2, size - 2);
    }
}
