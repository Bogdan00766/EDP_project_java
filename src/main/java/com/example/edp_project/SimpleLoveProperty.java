package com.example.edp_project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SimpleLoveProperty {
    @SerializedName("name1")
    @Expose
    private SimpleStringProperty name1;
    private SimpleStringProperty name2;
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty percentage;

    public String getName1() {
        return name1.get();
    }

    public void setName1(String name1) {
        this.name1 = new SimpleStringProperty(name1);
    }

    public String getName2() {
        return name2.get();
    }

    public void setName2(String name2) {
        this.name2 = new SimpleStringProperty(name2);
    }

    public int getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public int getPercentage() {
        return percentage.get();
    }

    public void setPercentage(Integer percentage) {
        this.percentage = new SimpleIntegerProperty(percentage);
    }
}
