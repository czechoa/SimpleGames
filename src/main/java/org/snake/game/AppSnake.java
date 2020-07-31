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

public class AppSnake implements StartScene {

    private int boardXSize = 500;
    private int boardYSize = 500;
    private int snakeAmountPart = 10;
    boolean onlyInStart = true;

    public AppSnake() {
        Fruit.setDefaultSizeSize();
        SnakePart.setDefaultSizeSize();

    }

    public AppSnake(int boardXSize, int boardYSize, int snakeAmountPart) {

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
            if (key.getCode() == KeyCode.SPACE && onlyInStart) {
                onlyInStart = false;
                runLoop.start();
            }
            if (!snake.isAlive() && key.getCode() == KeyCode.ENTER) {
                Main.setScene(new Menu());
            }

        });
        stage.setScene(scene);
        stage.centerOnScreen();
        runLoop.pressSpaceToStartGame();
    }

}
