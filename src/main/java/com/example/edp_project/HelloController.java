package com.example.edp_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class HelloController {
    @FXML
    public TextField imie2TextField;
    @FXML
    public TextField imie1TextField;
    @FXML
    public Label wynikText;
    @FXML
    public CheckBox pewnyCheckBox;
    @FXML
    private Label welcomeText;


    public void onSprawdzButtonClick(ActionEvent actionEvent) {
        wynikText.setText(null);
        if(imie2TextField.getText().contains("Soplica")) {
            wynikText.setText(("Lepszej połówki nie znajdziesz <3"));
            return;
        }
        if(imie1TextField.getText().isEmpty() || imie2TextField.getText().isEmpty()) {
            wynikText.setText("Oba pola imion muszą być wypełnione");
            return;
        }
        if(!pewnyCheckBox.isSelected()){
            wynikText.setText(("Zaznacz pole pewności"));
            return;
        }




    }
}