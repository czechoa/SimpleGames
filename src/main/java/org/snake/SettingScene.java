package org.snake;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class SettingScene implements StartScene{
    Button button;
    Slider slider;
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
        double tmp = slider.getValue();

    }

}
