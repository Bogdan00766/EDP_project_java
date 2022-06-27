package com.example.edp_project.Events;

import com.example.edp_project.HelloController;
import com.google.common.eventbus.Subscribe;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EventListener {

    @Subscribe
    public void DbSavingDoneEvent(DbSavingDoneEvent dbEvent){
        Alert alert = new Alert(Alert.AlertType.NONE, "Pomyślnie zapisano w bazie danych", ButtonType.OK);
        alert.setTitle("Baza danych");
        alert.showAndWait();
    }
}
