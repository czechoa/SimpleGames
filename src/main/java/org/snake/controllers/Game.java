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

    public static Canvas canvas;


    private static int boardXSize = 500;
    private static int boardYSize = 500;
    private int snakeAmountPart = 10;
    boolean onlyInStart = true;
    Scene scene = null;
    Stage stage;

    public Game() {

    }

    public Game(int boardXSize, int boardYSize, int snakeAmountPart) {

        Game.boardXSize = boardXSize;
        Game.boardYSize = boardYSize;
        this.snakeAmountPart = snakeAmountPart;
    }

    @Override
    public void start(Stage stage) {
        System.out.println("START " + boardXSize);
        System.out.println("START " + boardYSize);
        try {
            scene = new Scene(Main.loadFXML("game"), boardXSize, boardYSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.stage = stage;
        stage.setScene(scene);
        stage.centerOnScreen();
        new AppSnake(boardXSize,boardYSize,snakeAmountPart,scene,canvas);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(boardXSize);
        System.out.println(boardYSize);

        canvasfxml.setWidth(boardXSize);
        canvasfxml.setHeight(boardYSize);
        canvas = canvasfxml;
    }
}