module Jot {
    requires javafx.controls;
    requires javafx.fxml;

    opens jotGenerator to javafx.fxml;
    exports jotGenerator;
}