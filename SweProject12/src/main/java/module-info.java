module com.example.sweproject12 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.sweproject12 to javafx.fxml;
    exports com.example.sweproject12;
}