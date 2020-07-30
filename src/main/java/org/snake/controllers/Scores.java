package org.snake.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.snake.Score;
import org.snake.WriterReaderFileScore;

public class Scores implements StartScene, Initializable {
    @FXML
    TextArea text;
    @FXML
    TableView<Score> table;
    @FXML
    TableColumn<Score, String> result;
    @FXML
    TableColumn<Score, String> data;
    @FXML
    Button menu;

    @Override
    public void start(Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(Main.loadFXML("score"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);


    }
    public void handleButtonClick(ActionEvent actionEvent) throws IOException {
        Main.setScene(new Menu());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> list = WriterReaderFileScore.read();
        for (String result : list) {
            text.appendText(result + " \n");

        }

        text.setEditable(false);
        result.setCellValueFactory(new PropertyValueFactory<>("score"));

        data.setCellValueFactory(new PropertyValueFactory<>("data"));

        table.setItems(WriterReaderFileScore.read_1());

    }

    private ObservableList<Score> getProduct() {
        ObservableList<Score> products = FXCollections.observableArrayList();
        products.add(new Score("100", "data 1"));
        products.add(new Score("11","data 2"));
        return products;
    }
}
