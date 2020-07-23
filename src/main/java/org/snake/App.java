package org.snake;


import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        Scene scene = new Scene(loadFXML("sample"));
        stage.setScene(scene);
        stage.show();
    }

    static void setScene(StartScene startScene) {
        startScene.start(stage);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}