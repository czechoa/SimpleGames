package org.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Point {
    protected int xPosition;
    protected int yPosition;

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

    public abstract void paint(GraphicsContext graphics);
}
