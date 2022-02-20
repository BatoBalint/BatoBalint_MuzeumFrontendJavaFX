package com.example.muzeum.Controllers;

import com.example.muzeum.Api;
import com.example.muzeum.Painting;
import javafx.scene.control.*;
import javafx.fxml.FXML;

public class AddPaintingController {

    @FXML
    private Button addBtn;
    @FXML
    private TextField titleInput;
    @FXML
    private Spinner yearInput;
    @FXML
    private CheckBox onDisplayInput;

    @FXML
    public void addBtnClick() {
        Painting p = new Painting(0, "LajosKep", 1999, true);
        try {
            if (!Api.addPainting(p)) new Alert(Alert.AlertType.INFORMATION, "Valami okból nem sikerült elmenteni az új festményt", ButtonType.OK).show();
            else new Alert(Alert.AlertType.INFORMATION, "A festmény sikeresen elmentve", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
