package org.snake;

import javafx.scene.canvas.GraphicsContext;

public abstract class Point {
    protected int xPosition;
    protected int yPosition;
    protected int size;

    Point(int xPosition,int yPosition,int size){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getSize() {
        return size;
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

    public abstract void paint(GraphicsContext graphics);
}
