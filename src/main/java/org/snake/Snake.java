package org.snake;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Snake {
    private final int snakeItemSize = 10;
    private final int boardWidth;
    private final int boardHeight;
    ArrayList<Point> snake = new ArrayList<>();
    private Direction direction = Direction.LEFT;
    private int moveX;
    private int moveY;
    private boolean alive = true;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    Snake(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        createSnake();
    }

    private void createSnake() {
        snake.add(new Point(boardWidth / 2 - snakeItemSize, boardHeight / 2)); // head
        snake.add(new Point(boardWidth / 2, boardHeight / 2));
        snake.add(new Point(boardWidth / 2 + snakeItemSize, boardHeight / 2));
        snake.add(new Point(boardWidth / 2 + snakeItemSize * 2, boardHeight / 2));
        snake.add(new Point(boardWidth / 2 + snakeItemSize * 3, boardHeight / 2));
        snake.add(new Point(boardWidth / 2 + snakeItemSize * 4, boardHeight / 2));
        snake.add(new Point(boardWidth / 2 + snakeItemSize * 5, boardHeight / 2));
    }

    public void tick(GraphicsContext graphics) {
        setSnakeItemSizePosition();
        Point head = snake.get(0);
        if (outOfBoard(head)) {
            alive = false;
            return;
        }
        Boolean notFirst = false;
        for (Point point : snake) {
            if (notFirst) {
                if (collision(head, point)) {
                    alive = false;
                    return;
                }
            }
            notFirst = true;
            paint(graphics,point);
        }
    }

    public void paint(GraphicsContext graphics, Point point) {
        graphics.setFill(Color.WHITE);
        graphics.fillRect(point.getxPosition(), point.getyPosition(), snakeItemSize, snakeItemSize);
        graphics.setFill(Color.GRAY);
        graphics.fillRect(point.getxPosition() + 1, point.getyPosition() + 1, snakeItemSize - 2, snakeItemSize - 2);
    }

    private void setSnakeItemSizePosition() {
        for (int i = snake.size() - 1; i >= 0; i--) {
            Point point = snake.get(i);
            if (i == 0) { // head
                chooseMove();
                point.setxPosition(point.getxPosition() + moveX);
                point.setyPosition(point.getyPosition() + moveY);

            } else {
                point.setxPosition(snake.get(i - 1).getxPosition());
                point.setyPosition(snake.get(i - 1).getyPosition());
            }

        }
    }

    private boolean outOfBoard(Point head) {
        int x = head.getxPosition();
        int y = head.getyPosition();
        return x < 0 || x > boardWidth || y < 0 || y > boardHeight;
    }

    private boolean collision(Point head, Point point) {

        if (head.getxPosition() + snakeItemSize > point.getxPosition()) {
            if (head.getxPosition() < point.getxPosition() + snakeItemSize) {
                if (head.getyPosition() + snakeItemSize > point.getyPosition()) {
                    return head.getyPosition() < point.getyPosition() + snakeItemSize;
                }
            }
        }
        return false;
    }

    private void chooseMove() {
        moveX = 0;
        moveY = 0;
        if (direction == Direction.LEFT) {
            moveX -= snakeItemSize;
        } else if (direction == Direction.RIGHT) {
            moveX += snakeItemSize;
        } else if (direction == Direction.DOWN) {
            moveY += snakeItemSize;
        } else if (direction == Direction.UP) {
            moveY -= snakeItemSize;
        }
    }

}
