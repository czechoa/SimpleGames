package org.snake;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RunLoop extends AnimationTimer {
    private Canvas canvas;
    private int speed = 10; // TODO
    private final GraphicsContext graphics;
    long  lastTick = 0;
    Snake snake;


    RunLoop(Canvas canvas, Snake snake){
        this.canvas = canvas;
        graphics = canvas.getGraphicsContext2D();
        this.snake = snake;


    }

    @Override
    public void handle(long now) {
        if (lastTick == 0) {
            lastTick = now;
            tick();
            return;
        }

        if (now - lastTick > 1000000000 / speed) {
            lastTick = now;
            tick();
        }
    }
    private void tick(){
        graphics.setFill(Color.BLACK);
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        snake.tick(graphics);
        if(!snake.isAlive()){
            System.out.println("is live "+ snake.isAlive());
            System.out.println("died");
            System.exit(1);
        }
    }
}