module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.snake.controller to javafx.fxml;
    exports org.snake.controller;
}