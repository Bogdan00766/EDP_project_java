module com.example.edp_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.net.http;
    requires com.google.gson;
    requires java.sql;
    requires guava;
    requires org.apache.commons.configuration2;

    opens com.example.edp_project to javafx.fxml;
    exports com.example.edp_project;
    exports com.example.edp_project.Events;
    opens com.example.edp_project.Events to javafx.fxml;
}