module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.snake to javafx.fxml;
    exports org.snake;
}