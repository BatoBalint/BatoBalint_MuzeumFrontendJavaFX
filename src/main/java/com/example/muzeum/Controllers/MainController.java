package com.example.muzeum.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button delBtn;
    @FXML
    private TableView paintingTable;
    @FXML
    private TableColumn pTabName;
    @FXML
    private TableColumn pTabYear;
    @FXML
    private TableColumn pTabDisplay;
    @FXML
    private TableView statueTable;
    @FXML
    private TableColumn sTabPerson;
    @FXML
    private TableColumn sTabHeight;
    @FXML
    private TableColumn sTabPrice;



    public void initialize() {

    }

    public void testAlert() {
        new Alert(Alert.AlertType.NONE, "Test", ButtonType.OK).show();
    }
}