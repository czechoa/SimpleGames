package org.snake.game;

import javafx.scene.canvas.GraphicsContext;

public abstract class Point {
    protected int xPosition;
    protected int yPosition;
    protected int size;

    Point(int xPosition, int yPosition, int size) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.size = size;
    }

    public int getSize() {
        return size;
    }


    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setPosition(int xPosition,int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public abstract void paint(GraphicsContext graphics);
}
