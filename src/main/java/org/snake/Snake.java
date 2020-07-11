package org.snake;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Snake {
    private final int speed = 10;
    private final int score = 0;
    private final int startLength = 3;
    private final int snakeItemSize = 10;
    ArrayList<Point> snake = new ArrayList<>();
    private Direction direction = Direction.LEFT;
    private int moveX;
    private int moveY;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    Snake(int boardWidth, int boardHeight) {
        for (int i = 0; i < startLength; i++) {
            snake.add(new Point(boardWidth / 2, boardHeight / 2));
            snake.add(new Point(boardWidth / 2 - snakeItemSize, boardHeight / 2));
            snake.add(new Point(boardWidth / 2 + snakeItemSize, boardHeight / 2));
        }
    }

    public void tick(GraphicsContext graphics) {
        chooseMove();

        for (Point point : snake) {
            graphics.setFill(Color.WHITE);
            point.setxPosition(point.getxPosition() + moveX);
            point.setyPosition(point.getyPosition() + moveY);
            graphics.fillRect(point.getxPosition(), point.getyPosition(), snakeItemSize, snakeItemSize);
            graphics.setFill(Color.GRAY);
            graphics.fillRect(point.getxPosition() + 1, point.getyPosition() + 1, snakeItemSize - 2, snakeItemSize - 2);
        }

    }

    private void chooseMove() {
        moveX = 0;
        moveY = 0;
        if (direction == Direction.LEFT) {
            moveX -= speed;
        }else if (direction == Direction.RIGHT) {
            moveX += speed;
        }else if (direction == Direction.DOWN) {
            moveY += speed;
        }else if (direction == Direction.UP) {
            moveY -= speed;
        }
    }

    public int getSpeed() {
        return speed;
    }
}
