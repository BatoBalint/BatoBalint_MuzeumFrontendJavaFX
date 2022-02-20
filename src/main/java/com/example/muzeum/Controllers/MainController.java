package com.example.muzeum.Controllers;

import com.example.muzeum.Api;
import com.example.muzeum.MuzeumApp;
import com.example.muzeum.Painting;
import com.example.muzeum.Statue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

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

        loadDataToTables();
    }

    @FXML
    public void addBtnClick() {
        switch (selectedTab) {
            case 0: openNewWindow("add-statue-view.fxml", "Szobor felvétel");
                break;
            case 1: openNewWindow("add-painting-view.fxml", "Festmény felvétel");
                break;
        }
    }

    //region Edits
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
            alert(Alert.AlertType.NONE, "Nem támogatott funkcio");
        }
    }

    private void editPainting() {
        if (itemIsSelected(paintingTable, "festményt")) {
            alert(Alert.AlertType.NONE, "Nem támogatott funkcio");
        }
    }
    //endregion

    //region Deletes
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
            try {
                Api.deleteStatue(statueTable.getSelectionModel().getSelectedItem().getId());
                loadDataToTables();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deletePainting() {
        if (itemIsSelected(paintingTable, "festményt")) {
            try {
                Api.deletePainting(paintingTable.getSelectionModel().getSelectedItem().getId());
                loadDataToTables();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //endregion

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

    private void loadDataToTables() {
        paintingTable.getItems().clear();
        statueTable.getItems().clear();
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

    private void openNewWindow(String fxml, String title) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(MuzeumApp.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.setOnCloseRequest(v -> {
                loadDataToTables();
            });
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}