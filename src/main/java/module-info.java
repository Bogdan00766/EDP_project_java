module com.example.edp_project {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                        
    opens com.example.edp_project to javafx.fxml;
    exports com.example.edp_project;
}