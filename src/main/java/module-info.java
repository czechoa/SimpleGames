module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.snake to javafx.base;
    opens org.snake.controllers to javafx.fxml;
    exports org.snake.controllers;
}