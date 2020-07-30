package org.snake.game;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.snake.WriterReaderFileScore;

public class RunLoop extends AnimationTimer {

    private final double scoreStringSize;
    private final Canvas canvas;
    private int speed;
    private final GraphicsContext graphics;
    private long lastTick = 0;
    private final Snake snake;
    private final double stringSize;
    private final String namePlayer = "Player 1";


    RunLoop(Canvas canvas, Snake snake) {
        this.canvas = canvas;
        graphics = canvas.getGraphicsContext2D();
        this.snake = snake;
        stringSize = Math.sqrt(canvas.getWidth() * canvas.getHeight()) / 8;
        scoreStringSize = stringSize / 2;

    }

    @Override
    public void handle(long now) {
        if (lastTick == 0) {
            lastTick = now;
            tick();
            return;
        }

        if (now - lastTick > 1000000000 / (speed + 4)) {
            lastTick = now;
            tick();
            speed = snake.getLevel();
        }
    }

    private void tick() {
        graphics.setFill(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (snake.isAlive()) {
            snake.tick(graphics);
            graphics.setFill(Color.WHITE);
            graphics.setFont(new Font("", scoreStringSize));
            graphics.fillText("score: " + speed, 0, scoreStringSize);
        } else {
            String gameOver = "GAME OVER \n Score  " + snake.getLevel();
            writeStringToScreen(gameOver, Color.RED);
            stop();
            WriterReaderFileScore.write(snake.getLevel()+ " " +getCurrentTimeStamp()  );
        }
    }

    public void pressSpaceToStartGame() {
        tick();
        writeStringToScreen("Press Space \n to Start ", Color.GREEN);
    }

    private void writeStringToScreen(String string, Color color) {
        graphics.setFill(color);
        graphics.setFont(new Font("", stringSize));
        graphics.fillText(string, canvas.getWidth() / 8, canvas.getHeight() / 2);
    }
    public String getCurrentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy ");
        Date now = new Date();
        String strDate = sdf.format(now);
        return strDate;
    }


}
