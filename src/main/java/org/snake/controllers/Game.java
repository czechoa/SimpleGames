package org.snake.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.snake.game.AppSnake;
import org.snake.game.Direction;
import org.snake.game.Fruit;
import org.snake.game.RunLoop;
import org.snake.game.Snake;
import org.snake.game.SnakePart;

public class Game implements StartScene, Initializable {

    @FXML
    public Canvas canvasfxml;

    public Canvas canvas;


    private final int boardXSize = 500;
    private final int boardYSize = 500;
    private final int snakeAmountPart = 10;
    boolean onlyInStart = true;
    Scene scene = null;
    Stage stage;
    int x = 10;
//    public Game() {
//        Fruit.setDefaultSizeSize();
//        SnakePart.setDefaultSizeSize();
//    }
//
//    public Game(int boardXSize, int boardYSize, int snakeAmountPart) {
//
//        this.boardXSize = boardXSize;
//        this.boardYSize = boardYSize;
//        this.snakeAmountPart = snakeAmountPart;
//    }

    @Override
    public void start(Stage stage) {

        System.out.println("start "+ x);
        try {
            scene = new Scene(Main.loadFXML("game"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("stop "+x);

        this.stage = stage;
        stage.setScene(scene);
        stage.centerOnScreen();

    }

    void run() {

//        System.out.println(x);
        Fruit.setDefaultSizeSize();
        SnakePart.setDefaultSizeSize();
        Snake snake = new Snake(boardXSize, boardYSize, snakeAmountPart);
        RunLoop runLoop = new RunLoop(canvasfxml, snake);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("tralal");
        if (canvasfxml == null) {
            System.out.println("null");
        }
        x =20;
        System.out.println(x);
        canvasfxml.setWidth(boardXSize);
        canvasfxml.setHeight(boardYSize);
        canvas = canvasfxml;
    }
}
