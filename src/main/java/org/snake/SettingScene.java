package org.snake;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.snake.game.AppSnake;
import org.snake.game.SnakePart;

public class SettingScene implements StartScene, Initializable {
    Button button;
    public Label label;
    public Slider slider;


    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(App.loadFXML("Setting"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }


    @FXML
    public void handleButtonClick(ActionEvent actionEvent) throws IOException {
        SnakePart.setSize((int) slider.getValue());
        System.out.println(slider.getValue());
        App.setScene(new AppSnake());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(String.format("%.2f", slider.getValue()));
        slider.valueProperty().addListener((ov, old_val, new_val) -> {
            label.setText(String.format("%.2f", new_val));
        });

    }
}
