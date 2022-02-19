package com.example.muzeum.Controllers;

import com.example.muzeum.Api;
import com.example.muzeum.Painting;
import com.example.muzeum.Statue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.nio.file.Paths;
import java.util.List;
import javafx.scene.media.AudioClip;

public class MainController {

    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button delBtn;
    @FXML
    private TableView<Painting> paintingTable;
    @FXML
    private TableColumn<Painting, String> pTabName;
    @FXML
    private TableColumn<Painting, Integer> pTabYear;
    @FXML
    private TableColumn<Painting, String> pTabDisplay;
    @FXML
    private TableView<Statue> statueTable;
    @FXML
    private TableColumn<Statue, String> sTabPerson;
    @FXML
    private TableColumn<Statue, Integer> sTabHeight;
    @FXML
    private TableColumn<Statue, Integer> sTabPrice;
    @FXML
    private TabPane tabPane;

    private int selectedTab;


    public void initialize() {
        pTabName.setCellValueFactory(new PropertyValueFactory<>("name"));
        pTabYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        pTabDisplay.setCellValueFactory(new PropertyValueFactory<>("onDisplayString"));

        sTabPerson.setCellValueFactory(new PropertyValueFactory<>("person"));
        sTabHeight.setCellValueFactory(new PropertyValueFactory<>("height"));
        sTabPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        try {
            List<Painting> paintings = Api.getPaintings();
            for(Painting p : paintings) {
                paintingTable.getItems().add(p);
            }
            List<Statue> statues = Api.getStatues();
            for (Statue s : statues) {
                statueTable.getItems().add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addBtnClick() {
        switch (selectedTab) {
            case 0:
                break;
            case 1:
                break;
        }
    }

    @FXML
    public void editBtnClick() {
        switch (selectedTab) {
            case 0: editStatue();
                break;
            case 1: editPainting();
                break;
        }
    }

    private void editStatue() {
        if (itemIsSelected(statueTable, "szobrot")) {

        }
    }

    private void editPainting() {
        if (itemIsSelected(paintingTable, "festményt")) {

        }
    }

    @FXML
    public void delBtnClick() {
        switch (selectedTab) {
            case 0: deleteStatue();
                break;
            case 1: deletePainting();
                break;
        }
    }

    private void deleteStatue() {
        if (itemIsSelected(statueTable, "szobrot")) {

        }
    }

    private void deletePainting() {
        if (itemIsSelected(paintingTable, "festményt")) {

        }
    }

    private boolean itemIsSelected(TableView table, String errorMessage) {
        if (table.getSelectionModel().getSelectedIndex() == -1) {
            noSelectedItem(errorMessage);
            return false;
        }
        return true;
    }

    private void noSelectedItem(String text) {
        alert(Alert.AlertType.WARNING, "Elöbb válasszon ki egy " + text + ".");
    }

    @FXML
    public void tabPaneClicked() {
        selectedTab = tabPane.getSelectionModel().getSelectedIndex();
        clearSelectedItem();
    }

    public void alert(Alert.AlertType alertType, String text) {
        new Alert(alertType, text, ButtonType.OK).show();
    }

    public void windowClicked() {
        clearSelectedItem();
    }

    public void clearSelectedItem() {
        statueTable.getSelectionModel().clearSelection();
        paintingTable.getSelectionModel().clearSelection();
    }
}