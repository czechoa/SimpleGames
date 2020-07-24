package org.snake.game;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.snake.StartScene;

public class AppSnake implements StartScene {

    private int boardXSize = 500;
    private int boardYSize = 500;
    private int snakeAmountPart = 10;
    public AppSnake(){

    }
    public AppSnake(int boardXSize,int boardYSize,int snakeAmountPart){

        this.boardXSize = boardXSize;
        this.boardYSize = boardYSize;
        this.snakeAmountPart = snakeAmountPart;
    }
    @Override
    public void start(Stage stage) {

        HBox hBox = new HBox();
        Canvas canvas = new Canvas(boardXSize, boardYSize);
        hBox.getChildren().add(canvas);

        Snake snake = new Snake(boardXSize, boardYSize, snakeAmountPart);
        RunLoop runLoop = new RunLoop(canvas, snake);
        runLoop.start();

        Scene scene = new Scene(hBox, boardXSize, boardYSize);

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

        });
        stage.setScene(scene);

    }

//    public static void setBoardXSize(int boardXSize) {
//        AppSnake.boardXSize = boardXSize;
//    }
//
//    public static void setSnakeAmountPart(int snakeAmountPart) {
//        AppSnake.snakeAmountPart = snakeAmountPart;
//    }

}
