package com.example.muzeum.Controllers;

import com.example.muzeum.Api;
import com.example.muzeum.Painting;
import com.example.muzeum.Statue;
import javafx.scene.control.*;
import javafx.fxml.FXML;

public class AddPaintingController {

    @FXML
    private Button addBtn;
    @FXML
    private TextField titleInput;
    @FXML
    private Spinner<Integer> yearInput;
    @FXML
    private CheckBox onDisplayInput;

    @FXML
    public void addBtnClick() {
        Painting p = validate();
        if (p != null) {
            add(p);
            clearInputs();
        }
    }

    private Painting validate() {
        String title = titleInput.getText().trim();
        int year = yearInput.getValue();
        boolean onDisplay = onDisplayInput.isSelected();

        StringBuilder error = new StringBuilder();

        if (title.equals("")) {
            error.append("Nem lehet a festmény neve üres\n");
        } else if (title.length() > 255) {
            error.append("A festmény neve maximum 255 karakter lehet\n");
        }

        if (error.length() == 0) {
            return new Painting(0, title, year, onDisplay);
        }
        else {
            alert(Alert.AlertType.WARNING, error.toString());
            return null;
        }
    }

    private void add(Painting p) {
        try {
            if (!Api.addPainting(p)) alert(Alert.AlertType.INFORMATION, "Valami okból nem sikerült elmenteni az új festményt");
            else alert(Alert.AlertType.INFORMATION, "A festmény sikeresen elmentve");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearInputs() {
        titleInput.setText("");
        yearInput.getValueFactory().setValue(1900);
        onDisplayInput.selectedProperty().set(false);
    }

    private void alert(Alert.AlertType alertType, String text) {
        new Alert(alertType, text, ButtonType.OK).show();
    }
}
