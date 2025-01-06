module com.assignment2.beveragesanddrinkssystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.assignment2.beveragesanddrinkssystem to javafx.fxml;
    exports com.assignment2.beveragesanddrinkssystem;
}