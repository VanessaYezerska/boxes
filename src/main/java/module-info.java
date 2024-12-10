module com.example.boxes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.boxes to javafx.fxml;
    exports com.example.boxes;
}