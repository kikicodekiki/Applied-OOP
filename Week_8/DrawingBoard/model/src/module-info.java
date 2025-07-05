module model {
    requires javafx.controls;
    requires javafx.fxml;
    opens geometry to javafx.fxml; // add the name of our current package
    exports geometry to javafx.graphics, gui;
    // exports geometry -> can be accessed from all other modules
}