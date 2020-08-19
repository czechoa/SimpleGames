package org.snake.controllers;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.snake.game.AppSnake;

public class Menu implements StartScene {


//    public void handleButtonClick() {
//        Main.setScene(new AppSnake());
//    }
    public void handleButtonClick() {
        Game game = new Game();
        Main.setScene(game);
        game.run();

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
        Scene scene = null;
        try {
            scene = new Scene(Main.loadFXML("menu"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
}
