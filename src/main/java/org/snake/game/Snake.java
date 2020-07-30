package org.snake.game;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

public class Snake {

    private final int amountSnakePartInStart;
    private final int snakePartSize;
    private final int boardWidth;
    private final int boardHeight;
    private final ArrayList<SnakePart> snake = new ArrayList<>(); // Arraylist tez moze byc

    private Fruit fruit;
    private Direction direction = Direction.LEFT;
    private int moveX;
    private int moveY;
    private boolean alive = true;

    Snake(int boardWidth, int boardHeight, int amountSnakePartInStart) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.snakePartSize = SnakePart.getSnakePartSize();
        this.amountSnakePartInStart = amountSnakePartInStart;
        createSnake();
    }

    private void createSnake() {
        for (int i = 0; i < amountSnakePartInStart; i++) {
            SnakePart snakePart;
            try {
                SnakePart snakePartLast = snake.get(i - 1);
                snakePart = new SnakePart(snakePartLast.xPosition + snakePartSize, snakePartLast.yPosition);//right
                if (outOfBoard(snakePart) || collisionWithAllPart(snakePart)) {
                    snakePart = new SnakePart(snakePartLast.xPosition, snakePartLast.yPosition + snakePartSize);//down
                    if (outOfBoard(snakePart) || collisionWithAllPart(snakePart)) {
                        snakePart = new SnakePart(snakePartLast.xPosition - snakePartSize, snakePartLast.yPosition);//left
                        if (outOfBoard(snakePart) || collisionWithAllPart(snakePart)) {
                            snakePart = new SnakePart(snakePartLast.xPosition, snakePartLast.yPosition - snakePartSize);//up
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                snakePart = new SnakePart(boardWidth / 2, boardHeight / 2); // head

            }
            snake.add(snakePart);
        }
        createNewFruit();

    }

    private boolean collisionWithAllPart(Point point) {
        for (SnakePart snakePart : snake) {
            if (collision(point, snakePart)) {
                return true;
            }
        }
        return false;
    }

    void tick(GraphicsContext graphics) {
        setSnakeItemSizePosition();
        SnakePart head = snake.get(0);

        if (outOfBoard(head)) {
            alive = false;
            return;
        }
        if (collision(head, fruit)) {
            createNewFruit();
            int lastSnakeItem = snake.size() - 1;
            int xPosition = snake.get(lastSnakeItem).getXPosition();
            int yPosition = snake.get(lastSnakeItem).getYPosition();
            snake.add(new SnakePart(xPosition, yPosition));
        }
        boolean notFirst = false;
        for (SnakePart point : snake) {
            if (notFirst) {
                if (collision(head, point)) {
                    alive = false;
                    return;
                }
            } else {
                notFirst = true;
            }
            point.paint(graphics);
        }
        fruit.paint(graphics);
    }

    private void createNewFruit() {
        do {
            fruit = Fruit.makeNewFruit(boardWidth, boardHeight);
        } while (collisionWithAllPart(fruit));
    }


    private void setSnakeItemSizePosition() {
        for (int i = snake.size() - 1; i >= 0; i--) {
            SnakePart point = snake.get(i);
            if (i == 0) { // head
                chooseMove();
                point.setXPosition(point.getXPosition() + moveX);
                point.setYPosition(point.getYPosition() + moveY);

            } else {
                point.setXPosition(snake.get(i - 1).getXPosition());
                point.setYPosition(snake.get(i - 1).getYPosition());
            }

        }
    }

    private boolean outOfBoard(SnakePart head) {
        int x = head.getXPosition();
        int y = head.getYPosition();
        return x < 0 || (x + snakePartSize) > boardWidth || y < 0 || (y + snakePartSize) > boardHeight;
    }

    private boolean collision(Point head, Point point) {
        if (head.getXPosition() + head.getSize() > point.getXPosition()) {
            if (head.getXPosition() < point.getXPosition() + point.getSize()) {
                if (head.getYPosition() + head.getSize() > point.getYPosition()) {
                    return head.getYPosition() < point.getYPosition() + point.getSize();

                }
            }
        }
        return false;
    }

    private void chooseMove() {
        moveX = 0;
        moveY = 0;
        if (direction == Direction.LEFT) {
            moveX -= snakePartSize;
        } else if (direction == Direction.RIGHT) {
            moveX += snakePartSize;
        } else if (direction == Direction.DOWN) {
            moveY += snakePartSize;
        } else if (direction == Direction.UP) {
            moveY -= snakePartSize;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getLevel() {
        return snake.size() - amountSnakePartInStart;
    }

}
