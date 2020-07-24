package org.snake.game;

import java.util.List;
import java.util.Objects;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.snake.Reader;
import org.snake.StartScene;

public class AppSnake implements StartScene {
    private static   int boardXSize;
    private static int boardYSize;
    private static int snakePartSize;
    private static int snakeAmountPart;
    private static int fruitSize;


    @Override
    public void start(Stage stage) {

        List<String> list = Reader.readerFile(Objects.requireNonNull(getClass().getClassLoader().getResource("dataToSnake")).getFile());

        boardXSize = getValueFromList(list,0);
        boardYSize = getValueFromList(list,1);
        snakePartSize = getValueFromList(list,2);
        snakeAmountPart = getValueFromList(list,3);
        fruitSize = getValueFromList(list,4);

//        SnakePart.setSize(snakePartSize);
//        Fruit.setSize(fruitSize);

        HBox hBox = new HBox();
        Canvas canvas = new Canvas(boardXSize, boardYSize);
        hBox.getChildren().add(canvas);

        Snake snake = new Snake(boardXSize, boardYSize,snakeAmountPart);
        RunLoop runLoop = new RunLoop(canvas, snake);
        runLoop.start();

        Scene scene = new Scene(hBox, boardXSize, boardYSize);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                snake.setDirection(Direction.UP);
            }
            if (key.getCode() == KeyCode.A) {
                snake.setDirection(Direction.LEFT);
            }
            if (key.getCode() == KeyCode.S) {
                snake.setDirection(Direction.DOWN);
            }
            if (key.getCode() == KeyCode.D) {
                snake.setDirection(Direction.RIGHT);
            }

        });
        stage.setScene(scene);

    }
    private int getValueFromList(List<String> list,int numberIndex){
        String[] oneLine = list.get(numberIndex).split("\\s+");
        return Integer.parseInt(oneLine[1]);
    }

    public static void setBoardXSize(int boardXSize) {
        AppSnake.boardXSize = boardXSize;
    }

    public static void setBoardYSize(int boardYSize) {
        AppSnake.boardYSize = boardYSize;
    }

    public static void setFruitSize(int fruitSize) {
        AppSnake.fruitSize = fruitSize;
    }

    public static void setSnakeAmountPart(int snakeAmountPart) {
        AppSnake.snakeAmountPart = snakeAmountPart;
    }

    public static void setSnakePartSize(int snakePartSize) {
        AppSnake.snakePartSize = snakePartSize;
    }
}
