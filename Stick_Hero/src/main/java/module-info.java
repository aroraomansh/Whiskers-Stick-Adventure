module com.example.stick_hero {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.stick_hero to javafx.fxml;
    exports com.example.stick_hero;
}