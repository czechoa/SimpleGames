package org.snake;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.snake.game.AppSnake;
import org.snake.game.SnakePart;

public class SettingScene implements StartScene{
    Button button;

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

    public void handleButtonClick(ActionEvent actionEvent) throws IOException {
        SnakePart.setSize((int) slider.getValue());
        System.out.println(slider.getValue());
        App.setScene(new AppSnake());
    }

}
