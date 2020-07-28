package org.snake;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ScoreScene implements StartScene, Initializable {
    @FXML
    TextArea text;

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(App.loadFXML("score"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> list = WriterScore.read();
        for (String result : list) {
            text.appendText(result + " \n");

        }
        text.setEditable(false);

    }
}
