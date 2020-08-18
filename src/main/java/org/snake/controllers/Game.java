package org.snake.controllers;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.snake.game.AppSnake;

public class Game implements StartScene {
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
        new AppSnake();
    }
}
