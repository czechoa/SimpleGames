package org.snake.controllers;


import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.snake.WriterReaderFileScore;


public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) {
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/snake.png")));
        Main.stage = stage;
        setScene(new Menu());

    }

    public static void setScene(StartScene startScene) {
        startScene.start(stage);
    }

    static Parent loadFXML(String fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}