module com.example.stickhero {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example.stickhero to javafx.fxml;
    exports com.example.stickhero;
}