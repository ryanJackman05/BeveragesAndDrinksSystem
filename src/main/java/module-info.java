module com.assignment2.beveragesanddrinkssystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.assignment2.beveragesanddrinkssystem to javafx.fxml, xstream;
    opens controller to xstream;
    opens Model to xstream;
    exports com.assignment2.beveragesanddrinkssystem;
    exports controller to xstream;
    exports Model to xstream;
}