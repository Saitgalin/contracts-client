package com.test.contractsclient;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Contract {

    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private boolean actuality;

    public ObservableValue<String> updatedDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return new SimpleStringProperty(simpleDateFormat.format(updatedAt));
    }

    public ObservableValue<String> createdDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return new SimpleStringProperty(simpleDateFormat.format(createdAt));
    }

    public ObservableBooleanValue isChecked() {
        return new SimpleBooleanProperty(isActuality());
    }

}
