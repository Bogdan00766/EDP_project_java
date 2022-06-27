package com.example.edp_project;

import Database.DbContext;
import com.example.edp_project.Events.DbSavingDoneEvent;
import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField imie2TextField;
    @FXML
    public TextField imie1TextField;
    @FXML
    public Label wynikText;
    @FXML
    public CheckBox pewnyCheckBox;
    public Button historyButton;
    @FXML
    private Label welcomeText;


    public void onSprawdzButtonClick(ActionEvent actionEvent) {
        wynikText.setText(null);
        if(imie2TextField.getText().contains("Soplica")) {
            wynikText.setText(("Lepszej połówki nie znajdziesz <3"));
            return;
        }
        if(imie1TextField.getText().isEmpty() || imie2TextField.getText().isEmpty()) {
            wynikText.setText("Both name boxes have to be filled");
            return;
        }
        if(!pewnyCheckBox.isSelected()){
            wynikText.setText(("Sing checkbox"));
            return;
        }
        Request request = new Request();
        var lr = request.CheckLove(imie1TextField.getText(), imie2TextField.getText());
        wynikText.setText("Result: " + lr.percentage + "\n" + lr.result);

        DbContext dbContext = new DbContext(this);
        dbContext.start();
        dbContext.Insert(lr.sname, lr.fname, lr.percentage);
        try {
            dbContext.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Subscribe
    public void DbSavingDoneEvent(DbSavingDoneEvent dbEvent){
        Alert alert = new Alert(Alert.AlertType.NONE, "Saving in database sucessfull!", ButtonType.OK);
        alert.setTitle("Database info");
        alert.showAndWait();
    }

    public void onHistoryButtonClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("history-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Tests History");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}