package org.snake.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
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
    }

    public void handleButtonYesClick(ActionEvent actionEvent) throws IOException {
        System.exit(1);
    }

    public void handleButtonNoClick(ActionEvent actionEvent) throws IOException {
        Main.setScene(new Menu());
    }

}
