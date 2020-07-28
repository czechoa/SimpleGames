package org.snake;

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

public class Controller implements Initializable,StartScene {
    public Button button;
    public Button buttonOut;
    public Label firstLabel;
    String message = "";
    private Stage stage;

    public void handleButtonClick(ActionEvent actionEvent) throws IOException {
        App.setScene(new AppSnake());
    }

    public void handleButtonOutClick(ActionEvent actionEvent) throws IOException {
        App.setScene(new SceneOut());
    }

    public void handleButtonSettingClick(ActionEvent actionEvent) throws IOException {
        App.setScene(new SettingScene());
    }
    public void handleButtonScoreClick(ActionEvent actionEvent) throws IOException {
        App.setScene(new ScoreScene());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("loading user data ..  "); // wykonuje sie od razu
    }

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(App.loadFXML("sample"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();

    }
}
