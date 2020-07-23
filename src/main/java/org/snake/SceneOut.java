package org.snake;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneOut implements StartScene{
    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(App.loadFXML("out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public void handleButtonYesClick(ActionEvent actionEvent) throws IOException {
        System.exit(1);
    }
    public void handleButtonNoClick(ActionEvent actionEvent) throws IOException{
        App.setScene(new Controller());
    }

}
