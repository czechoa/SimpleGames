package org.snake.controller;

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
import org.snake.Result;
import org.snake.WriterReaderFileScore;

public class ScoreScene implements StartScene, Initializable {
    @FXML
    TextArea text;
    @FXML
    TableView<Result> table;
    @FXML
    TableColumn<Result, String> result;
    @FXML
    TableColumn<Result, String> data;
    @FXML
    Button menu;

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
    public void handleButtonClick(ActionEvent actionEvent) throws IOException {
        App.setScene(new Controller());
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

    private ObservableList<Result> getProduct() {
        ObservableList<Result> products = FXCollections.observableArrayList();
        products.add(new Result("100", "data 1"));
        products.add(new Result("11","data 2"));
        return products;
    }
}
