package org.snake.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.snake.game.AppSnake;

public class Game implements StartScene, Initializable {

    @FXML
    public Canvas canvasFxml;

    public static Canvas canvas;


    private static int boardXSize = 500;
    private static int boardYSize = 500;
    private static int snakeAmountPart = 10;

    public Game() {

    }

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(Main.loadFXML("game"), boardXSize, boardYSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.centerOnScreen();
        new AppSnake(boardXSize, boardYSize, snakeAmountPart, scene, canvas);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvasFxml.setWidth(boardXSize);
        canvasFxml.setHeight(boardYSize);
        canvas = canvasFxml;
    }

    public static void setBoardXSize(int boardXSize) {
        Game.boardXSize = boardXSize;
    }

    public static void setBoardYSize(int boardYSize) {
        Game.boardYSize = boardYSize;
    }

    public static void setSnakeAmountPart(int snakeAmountPart) {
        Game.snakeAmountPart = snakeAmountPart;
    }
}