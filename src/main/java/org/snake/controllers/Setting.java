package org.snake.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import org.snake.game.AppSnake;
import org.snake.game.Fruit;
import org.snake.game.SnakePart;

public class Setting implements StartScene, Initializable {

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
            scene = new Scene(Main.loadFXML("setting"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.centerOnScreen();

    }


    @FXML
    public void handleButtonStartClick() {

        SnakePart.setSize((int) sliderSnakePartSize.getValue());
        Fruit.setSize((int) sliderFruitSize.getValue());
        Game game = new Game((int) sliderBoardWidth.getValue(), (int) sliderBoardHeight.getValue(), (int) sliderAmountSnakeParts.getValue());
        Main.setScene(game);
        game.run();
    }

    @FXML
    public void handleButtonMenuClick() {
        Main.setScene(new Menu());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addListener(sliderSnakePartSize, labelSnakePartSize);
        addListener(sliderAmountSnakeParts, labelAmountSnakeParts);
        addListener(sliderFruitSize, labelFruitSize);
        addListener(sliderBoardHeight, labelBoardHeight);
        addListener(sliderBoardWidth, labelBoardWidth);

    }

    private void addListener(Slider slider, Label label) {

        label.setText(String.format("%.0f", slider.getValue()));
        slider.valueProperty().addListener((ov, old_val, new_val) -> label.setText(String.format("%.0f", new_val)));
    }
}
