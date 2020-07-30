package org.snake;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ScoreScene implements StartScene, Initializable {
    @FXML
    TextArea text;
    @FXML
    TableView<Result> table;
    @FXML
    TableColumn<Result, String> result;
    @FXML
    TableColumn<Result, String> data;

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
        ArrayList<String> list = WriterReaderFileScore.read();
        for (String result : list) {
            text.appendText(result + " \n");

        }
        text.setEditable(false);
        //Price column
//        TableColumn<Result, String> priceColumn = new TableColumn<>("Price");
//        priceColumn.setMinWidth(100);
        result.setCellValueFactory(new PropertyValueFactory<>("score"));

        //Quantity column
//        TableColumn<Result, String> quantityColumn = new TableColumn<>("Quantity");
//        quantityColumn.setMinWidth(100);
        data.setCellValueFactory(new PropertyValueFactory<>("data"));

        table.setItems(getProduct());
//        table.getColumns().addAll(priceColumn, quantityColumn);

    }

    private ObservableList<Result> getProduct() {
        ObservableList<Result> products = FXCollections.observableArrayList();
        products.add(new Result("100", "data 1"));
        products.add(new Result("11","data 2"));
        return products;
    }
}
