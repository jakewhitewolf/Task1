module com.examle.task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.examle.task1 to javafx.fxml;
    exports com.examle.task1;
}