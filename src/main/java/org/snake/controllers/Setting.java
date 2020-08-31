package org.snake.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
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

    private static int snakePartSize = 50;
    private static int fruitSize = 10;
    private static int amountSnakeParts = 6;
    private static int boardWidth = 500;
    private static int boardHeight = 500;

    @Override
    public void start(Stage stage) {
        Main.loadScene("setting");

    }


    @FXML
    public void handleButtonStartClick() {
        setValueGame();
        Game game = new Game();
        Main.setScene(game);
    }

    @FXML
    public void handleButtonMenuClick() {
        setValueGame();
        Main.setScene(new Menu());
    }

    private void setValueGame() {
        SnakePart.setSize(snakePartSize = (int) sliderSnakePartSize.getValue());
        Fruit.setSize(fruitSize = (int) sliderFruitSize.getValue());
        Game.setBoardXSize(boardWidth = (int) sliderBoardWidth.getValue());
        Game.setBoardYSize(boardHeight = (int) sliderBoardHeight.getValue());
        Game.setSnakeAmountPart(amountSnakeParts = (int) sliderAmountSnakeParts.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListenerAndSetStartValueSlider(sliderSnakePartSize, labelSnakePartSize, snakePartSize);
        addListenerAndSetStartValueSlider(sliderAmountSnakeParts, labelAmountSnakeParts, amountSnakeParts);
        addListenerAndSetStartValueSlider(sliderFruitSize, labelFruitSize, fruitSize);
        addListenerAndSetStartValueSlider(sliderBoardHeight, labelBoardHeight, boardHeight);
        addListenerAndSetStartValueSlider(sliderBoardWidth, labelBoardWidth, boardWidth);

    }

    private void addListenerAndSetStartValueSlider(Slider slider, Label label, int startValue) {
        label.setText(String.format("%d", startValue));
        slider.setValue(startValue);
        slider.valueProperty().addListener((ov, old_val, new_val) -> label.setText(String.format("%d", new_val.intValue())));
    }
}
