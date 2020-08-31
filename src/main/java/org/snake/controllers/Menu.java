package org.snake.controllers;

import javafx.stage.Stage;

public class Menu implements StartScene {

    public void handleButtonClick() {
        Game game = new Game();
        Main.setScene(game);
    }

    public void handleButtonOutClick() {
        Main.setScene(new Out());
    }

    public void handleButtonSettingClick() {
        Main.setScene(new Setting());
    }

    public void handleButtonScoreClick() {
        Main.setScene(new Scores());
    }

    @Override
    public void start(Stage stage) {
        Main.loadScene("menu");
        stage.show();
    }
}
