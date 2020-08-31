package org.snake.game;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

public class Snake {

    private final int amountSnakePartInStart;
    private final int snakePartSize;
    private final int boardWidth;
    private final int boardHeight;
    private final ArrayList<SnakePart> snake = new ArrayList<>();

    private Fruit fruit;
    private Direction direction = Direction.LEFT;
    private int moveX;
    private int moveY;
    private boolean alive = true;

    public Snake(int boardWidth, int boardHeight, int amountSnakePartInStart) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.snakePartSize = SnakePart.getSnakePartSize();
        this.amountSnakePartInStart = amountSnakePartInStart;
        createSnake();
        createNewFruit();
    }

    private void createSnake() {
        for (int i = 0; i < amountSnakePartInStart; i++) {
            SnakePart snakePart;
            if (i == 0) {
                snakePart = new SnakePart(boardWidth / 2, boardHeight / 2); // head
            } else {
                SnakePart snakePartLast = snake.get(i - 1);
                snakePart = new SnakePart(snakePartLast.xPosition + snakePartSize, snakePartLast.yPosition);//right
                if (canNotCreateNewSnakePart(snakePart)) {
                    snakePart = new SnakePart(snakePartLast.xPosition, snakePartLast.yPosition + snakePartSize);//down
                    if (canNotCreateNewSnakePart(snakePart)) {
                        snakePart = new SnakePart(snakePartLast.xPosition - snakePartSize, snakePartLast.yPosition);//left
                        if (canNotCreateNewSnakePart(snakePart)) {
                            snakePart = new SnakePart(snakePartLast.xPosition, snakePartLast.yPosition - snakePartSize);//up
                        }
                    }
                }
            }
            snake.add(snakePart);
        }
    }

    private boolean canNotCreateNewSnakePart(SnakePart snakePart) {
        return outOfBoard(snakePart) || collisionWithSnake(snakePart);
    }

    private boolean collisionWithSnake(Point point) {
        for (SnakePart snakePart : snake) {
            if (point.collision(snakePart)) {
                return true;
            }
        }
        return false;
    }

    void tick(GraphicsContext graphics) {
        moveSnake();
        paintAndCollision(graphics);
        fruit.paint(graphics);
    }

    private void eatFruitAndGrown() {
        createNewFruit();
        int lastSnakeItem = snake.size() - 1;
        int xPosition = snake.get(lastSnakeItem).getXPosition();
        int yPosition = snake.get(lastSnakeItem).getYPosition();
        snake.add(new SnakePart(xPosition, yPosition));
    }

    private void paintAndCollision(GraphicsContext graphics) {
        SnakePart head = null;
        for (int i = 0; i < snake.size(); i++) {
            SnakePart snakePart = snake.get(i);
            if (i == 0) {
                head = snakePart;
                if (outOfBoard(head)) {
                    alive = false;
                    return;
                }
                if (head.collision(fruit)) {
                    eatFruitAndGrown();
                }
            } else {
                if (head.collision(snakePart)) {
                    alive = false;
                    return;
                }
            }
            snakePart.paint(graphics);
        }
    }

    private void createNewFruit() {
        do {
            fruit = Fruit.makeNewFruit(boardWidth, boardHeight);
        } while (collisionWithSnake(fruit));
    }

    private void moveSnake() {
        for (int i = snake.size() - 1; i >= 0; i--) {
            SnakePart point = snake.get(i);
            if (i == 0) { // head
                chooseMove();
                point.setPosition(point.getXPosition() + moveX, point.getYPosition() + moveY);
            } else {
                point.setPosition(snake.get(i - 1).getXPosition(), snake.get(i - 1).getYPosition());
            }
        }
    }

    private boolean outOfBoard(SnakePart head) {
        int x = head.getXPosition();
        int y = head.getYPosition();
        return x < 0 || (x + snakePartSize) > boardWidth || y < 0 || (y + snakePartSize) > boardHeight;
    }

    private synchronized void chooseMove() {
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

    public synchronized void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getLevel() {
        return snake.size() - amountSnakePartInStart;
    }
}
