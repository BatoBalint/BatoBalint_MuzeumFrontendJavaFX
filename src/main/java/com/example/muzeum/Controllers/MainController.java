package com.example.muzeum.Controllers;

import com.example.muzeum.Api;
import com.example.muzeum.Painting;
import com.example.muzeum.Statue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

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
    public void editBtnClick() {

    }

    @FXML
    public void delBtnClick() {

    }

    @FXML
    public void addBtnClick() {
        testAlert(tabPane.getSelectionModel().getSelectedItem().getText());
    }

    @FXML
    public void tabPaneClicked() {
        selectedTab = tabPane.getSelectionModel().getSelectedIndex();
    }

    public void testAlert() {
        new Alert(Alert.AlertType.NONE, "Test", ButtonType.OK).show();
    }

    public void testAlert(String text) {
        new Alert(Alert.AlertType.NONE, text, ButtonType.OK).show();
    }
}