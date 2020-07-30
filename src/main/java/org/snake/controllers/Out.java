package org.snake.controllers;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Out implements StartScene {
    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(Main.loadFXML("out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void handleButtonYesClick() {
        System.exit(0);
    }

    public void handleButtonNoClick() {
        Main.setScene(new Menu());
    }

}
