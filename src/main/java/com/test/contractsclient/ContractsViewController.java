package com.test.contractsclient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContractsViewController implements Initializable {

    @FXML
    private TableView<Contract> contractTableView;

    @FXML
    private TableColumn<Contract, Long> idCol;

    @FXML
    private TableColumn<Contract, String> createdAtCol;

    @FXML
    private TableColumn<Contract, String> updatedAtCol;

    @FXML
    private TableColumn<Contract, Boolean> actualityCol;

    ObservableList<Contract> contracts = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateContracts();
        contractTableView.setItems(contracts);
        loadProperties();
    }

    private void updateContracts () {
        RemoteController remoteController = new RemoteController();
        try {
            contracts.addAll(remoteController.getContracts());
        } catch (IOException | InterruptedException e) {
            sendError(e);
        }
    }

    private void sendError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Ошибка получения данных с сервера: " + e);
        alert.showAndWait();
        System.exit(0);
    }

    private void loadProperties() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        createdAtCol.setCellValueFactory(param -> param.getValue().createdDate());
        updatedAtCol.setCellValueFactory(param -> param.getValue().updatedDate());
        actualityCol.setCellValueFactory(param -> param.getValue().isChecked());
        actualityCol.setCellFactory(CheckBoxTableCell.forTableColumn(actualityCol));
    }
}