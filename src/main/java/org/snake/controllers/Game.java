package org.snake.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.snake.game.AppSnake;

public class Game implements StartScene {
    @FXML
    Canvas canvas;

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(Main.loadFXML("game"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.centerOnScreen();

        new AppSnake(10,10,10,canvas).start(stage);
    }
}
