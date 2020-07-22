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
    private int boardXSize;
    private int boardYSize;
    private int snakePartSize;
    private int snakeAmountPart;
    private int fruitSize;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        Scene scene = new Scene(loadFXML("sample"));
        stage.setScene(scene);
    }

    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
        new AppSnake(stage);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }
}