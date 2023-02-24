module com.example.dsm_402_qualite_vone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //estilo
    requires com.jfoenix;

    //json
    requires gson;
    requires java.sql;
    requires unirest.java;

    opens com.example.dsm_402_qualite_vone;
    exports com.example.dsm_402_qualite_vone;

    opens com.example.dsm_402_qualite_vone.model;
    exports com.example.dsm_402_qualite_vone.model;
}