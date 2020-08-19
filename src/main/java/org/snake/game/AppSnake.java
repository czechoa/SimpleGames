package org.snake.game;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.snake.controllers.Main;
import org.snake.controllers.Menu;
import org.snake.controllers.StartScene;

public class AppSnake{

    private int boardXSize = 500;
    private int boardYSize = 500;
    private int snakeAmountPart = 10;
    boolean onlyInStart = true;
    public static Canvas canvas;

    public static void setCanvas(Canvas canvas) {
        AppSnake.canvas = canvas;
    }

//    public AppSnake() {
//        Fruit.setDefaultSizeSize();
//        SnakePart.setDefaultSizeSize();
//        canvas = new Canvas();
//    }
//
//    public AppSnake(int boardXSize, int boardYSize, int snakeAmountPart, Canvas canvas) {
//
//        this.boardXSize = boardXSize;
//        this.boardYSize = boardYSize;
//        this.snakeAmountPart = snakeAmountPart;
//        this.canvas = canvas;
//    }

    public void start() {
        Fruit.setDefaultSizeSize();
        SnakePart.setDefaultSizeSize();
        canvas.setWidth(boardXSize);
        canvas.setHeight(boardYSize);
        Snake snake = new Snake(boardXSize, boardYSize, snakeAmountPart);
        RunLoop runLoop = new RunLoop(canvas, snake);
        runLoop.pressSpaceToStartGame();
    }

}
