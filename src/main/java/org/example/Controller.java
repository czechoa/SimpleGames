package org.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller implements Initializable {
    public Button button;
    public Label firstLabel;
    String message = "";

    public void handleButtonClick(ActionEvent actionEvent) {
        System.out.println("somthink happen ");
        button.setText("don't touch me");
        message += "trlalaa";
        firstLabel.setText(message);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading user data ..  "); // wykonuje sie od razu
    }
}
