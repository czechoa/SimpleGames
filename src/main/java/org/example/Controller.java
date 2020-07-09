package org.example;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    public Button button;

    public void handleButtonClick(ActionEvent actionEvent) {
        System.out.println("somthink happen ");
        button.setText("don't touch me");
    }
}
