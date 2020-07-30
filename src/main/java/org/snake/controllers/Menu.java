package org.snake.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.snake.game.AppSnake;

public class Menu implements Initializable, StartScene {
    public Button button;
    public Button buttonOut;
    public Label firstLabel;
    String message = "";
    private Stage stage;

    public void handleButtonClick(ActionEvent actionEvent) throws IOException {
        Main.setScene(new AppSnake());
    }

    public void handleButtonOutClick(ActionEvent actionEvent) throws IOException {
        Main.setScene(new Out());
    }

    public void handleButtonSettingClick(ActionEvent actionEvent) throws IOException {
        Main.setScene(new Setting());
    }
    public void handleButtonScoreClick(ActionEvent actionEvent) throws IOException {
        Main.setScene(new Scores());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading user data ..  "); // wykonuje sie od razu
    }

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(Main.loadFXML("sample"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();

    }
}
