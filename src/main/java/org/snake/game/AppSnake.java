package org.snake.game;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.snake.controllers.Main;
import org.snake.controllers.Menu;

public class AppSnake {

    private int boardXSize = 500;
    private int boardYSize = 500;
    private int snakeAmountPart = 10;
    private Scene scene;
    boolean onlyInStart = true;
    public Canvas canvas;


    public AppSnake(int boardXSize, int boardYSize, int snakeAmountPart, Scene scene, Canvas canvas) {
        this.boardXSize = boardXSize;
        this.boardYSize = boardYSize;
        this.snakeAmountPart = snakeAmountPart;
        this.scene = scene;
        this.canvas = canvas;
//        Fruit.setDefaultSizeSize();
//        SnakePart.setDefaultSizeSize();
        start();
    }

    public AppSnake(int boardXSize, int boardYSize, int snakeAmountPart) {

        this.boardXSize = boardXSize;
        this.boardYSize = boardYSize;
        this.snakeAmountPart = snakeAmountPart;
    }

    public void start() {
        Snake snake = new Snake(boardXSize, boardYSize, snakeAmountPart);
        RunLoop runLoop = new RunLoop(canvas, snake);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                snake.setDirection(Direction.UP);
            }
            if (key.getCode() == KeyCode.A) {
                snake.setDirection(Direction.LEFT);
            }
            if (key.getCode() == KeyCode.S) {
                snake.setDirection(Direction.DOWN);
            }
            if (key.getCode() == KeyCode.D) {
                snake.setDirection(Direction.RIGHT);
            }
            if (key.getCode() == KeyCode.SPACE && onlyInStart) {
                onlyInStart = false;
                runLoop.start();
            }
            if (!snake.isAlive() && key.getCode() == KeyCode.ENTER) {
                Main.setScene(new Menu());
            }

        });
        runLoop.pressSpaceToStartGame();
    }

}
