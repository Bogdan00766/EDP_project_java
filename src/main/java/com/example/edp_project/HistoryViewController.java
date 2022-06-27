package com.example.edp_project;

import Database.DbContext;
import Database.LoveHistoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class HistoryViewController implements Initializable {

    @FXML
    TableView historyTV;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn id = new TableColumn("Id");
        TableColumn sname = new TableColumn("Name1");
        TableColumn fname = new TableColumn("Name2");
        TableColumn percentage = new TableColumn("Percentage");
        historyTV.getColumns().addAll(id, sname, fname, percentage);

        ObservableList<SimpleLoveProperty> data = FXCollections.observableArrayList();
        DbContext dbContext = new DbContext(this);
        dbContext.start();
        var list =  dbContext.Read();
        if(list == null) return;
        for (var element : list) {
            var elem = new SimpleLoveProperty();
            elem.setId(element.getId());
            elem.setName1(element.getName1());
            elem.setName2(element.getName2());
            elem.setPercentage(element.getPercentage());
            data.add(elem);
        }
        id.setCellValueFactory(new PropertyValueFactory<SimpleLoveProperty, Integer>("id"));
        sname.setCellValueFactory(new PropertyValueFactory<SimpleLoveProperty, String>("name1"));
        fname.setCellValueFactory(new PropertyValueFactory<SimpleLoveProperty, String>("name2"));
        percentage.setCellValueFactory(new PropertyValueFactory<SimpleLoveProperty, Integer>("percentage"));

        historyTV.setItems(data);
    }

}
