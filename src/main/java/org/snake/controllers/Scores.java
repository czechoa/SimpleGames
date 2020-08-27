package org.snake.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.snake.Score;
import org.snake.WriterReaderFileScore;

public class Scores implements StartScene, Initializable {

    @FXML
    TableView<Score> table;
    @FXML
    TableColumn<Score, String> result;
    @FXML
    TableColumn<Score, String> data;

    @Override
    public void start(Stage stage) {
        Main.loadScene("scores");

    }

    public void handleButtonMenuClick() {
        Main.setScene(new Menu());
    }

    public void handleButtonStartClick() {
        Main.setScene(new Game());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        result.setCellValueFactory(new PropertyValueFactory<>("score"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));

        table.setItems(WriterReaderFileScore.read());
        table.setEditable(false);
    }
}
