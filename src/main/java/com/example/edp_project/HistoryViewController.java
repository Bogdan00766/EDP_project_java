package com.example.edp_project;

import Database.LoveHistoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;


public class HistoryViewController {
    @FXML
    TableView historyTV;

    public HistoryViewController(){
        LoveHistoryDto lh = new LoveHistoryDto();
        lh.setId(1);
        lh.setName1("xd");
        lh.setName2("2xd");
        lh.setPercentage(100);
        ObservableList<LoveHistoryDto> ol = FXCollections.observableArrayList();
        ol.add(lh);


    }

}
