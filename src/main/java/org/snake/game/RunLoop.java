package org.snake.game;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.snake.WriterReaderFileScore;

public class RunLoop extends AnimationTimer {

    private Canvas canvas;
    private int speed = 3;
    private final GraphicsContext graphics;
    long  lastTick = 0;
    Snake snake;
    private double stringSize;
    private String namePlayer = "Player 1";


    RunLoop(Canvas canvas, Snake snake){
        this.canvas = canvas;
        graphics = canvas.getGraphicsContext2D();
        this.snake = snake;
        stringSize = Math.sqrt(canvas.getWidth()*canvas.getHeight())/8;
    }

    @Override
    public void handle(long now) {
        if (lastTick == 0) {
            lastTick = now;
            tick();
            return;
        }

        if (now - lastTick > 1000000000 / (speed + 4 )) {
            lastTick = now;
            tick();
            speed = snake.getLevel();
        }
    }
    private void tick(){
        graphics.setFill(Color.BLACK);
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        writeStringToScreen("score :" +snake.getLevel(),Color.YELLOW);
        snake.tick(graphics);
        if(!snake.isAlive()){
            graphics.setFill(Color.BLACK);
            graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
            String gameOver = "GAME OVER \n Score  "  + snake.getLevel();
            writeStringToScreen(gameOver,Color.RED);
            stop();
            WriterReaderFileScore.write(" " +snake.getLevel());
        }
    }

    public void pressSpaceToStartGame(){
        tick();
        writeStringToScreen("Press Space \n to Start ",Color.GREEN);
    }
    private void writeStringToScreen(String string, Color color){
        graphics.setFill(color);
        graphics.setFont(new Font("", stringSize));
        graphics.fillText(string, canvas.getWidth()/8, canvas.getHeight()/2);
    }


}
