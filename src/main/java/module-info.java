
module com.example.healthvisualizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.healthvisualizer to javafx.fxml;
    exports com.example.healthvisualizer;
}