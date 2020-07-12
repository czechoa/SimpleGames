package org.snake;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {
    private final int boardXSize = 500;
    private final int boardYSize = 500;

    @Override
    public void start(Stage stage) {
        HBox hBox = new HBox();
        Canvas canvas = new Canvas(boardXSize, boardYSize);

        hBox.getChildren().add(canvas);
        Snake snake = new Snake(boardXSize, boardYSize);
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
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}