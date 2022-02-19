module com.example.muzeumfrontendjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.muzeum to javafx.fxml;
    exports com.example.muzeum;
    exports com.example.muzeum.Controllers;
    opens com.example.muzeum.Controllers to javafx.fxml;
}