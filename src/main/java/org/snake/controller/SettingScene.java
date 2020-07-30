package org.snake.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.snake.game.AppSnake;
import org.snake.game.Fruit;
import org.snake.game.SnakePart;

public class SettingScene implements StartScene, Initializable {
    Button button;
    public Label labelSnakePartSize;
    public Label labelFruitSize;
    public Label labelAmountSnakeParts;
    public Label labelBoardWidth;
    public Label labelBoardHeight;
    public Slider sliderSnakePartSize;
    public Slider sliderFruitSize;
    public Slider sliderAmountSnakeParts;
    public Slider sliderBoardWidth;
    public Slider sliderBoardHeight;


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


    @FXML
    public void handleButtonClick(ActionEvent actionEvent) throws IOException {

//        AppSnake.setBoardXSize((int)sliderBoardWidth.getValue());
//        AppSnake.setBoardXSize((int)sliderBoardHeight.getValue());
//
//        AppSnake.setSnakeAmountPart((int)sliderAmountSnakeParts.getValue());
        SnakePart.setSize((int) sliderSnakePartSize.getValue());
        Fruit.setSize((int)sliderFruitSize.getValue());

        System.out.println(sliderSnakePartSize.getValue());
        App.setScene(new AppSnake((int)sliderBoardWidth.getValue(),(int)sliderBoardHeight.getValue(),(int)sliderAmountSnakeParts.getValue()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener(sliderSnakePartSize,labelSnakePartSize);
        addListener(sliderAmountSnakeParts,labelAmountSnakeParts);

        addListener(sliderFruitSize,labelFruitSize);

        addListener(sliderBoardHeight,labelBoardHeight);
        addListener(sliderBoardWidth,labelBoardWidth);
    }

    private void addListener(Slider slider,Label label){

        label.setText(String.format("%.0f", slider.getValue()));
        slider.valueProperty().addListener((ov, old_val, new_val) -> {
            label.setText(String.format("%.0f", new_val));
        });
    }
}
