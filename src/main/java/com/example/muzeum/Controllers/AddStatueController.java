package com.example.muzeum.Controllers;

import com.example.muzeum.Api;
import com.example.muzeum.Statue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddStatueController {

    @FXML
    private Spinner<Integer> priceInput;
    @FXML
    private TextField personInput;
    @FXML
    private Spinner<Integer> heightInput;

    @FXML
    public void addBtnClick() {
        Statue s = validate();
        if (s != null) {
            add(s);
        }
    }

    public Statue validate() {
        String person = personInput.getText();
        int height = heightInput.getValue();
        int price = priceInput.getValue();

        StringBuilder error = new StringBuilder();

        if (person.trim().equals("")) {
            error.append("Nem lehet a név üres\n");
        } else if (person.trim().length() < 5) {
            error.append("A névnek legalább 5 karakternek kell lennie\n");
        }

        if (error.length() == 0) {
            return new Statue(0, person, height, price);
        }
        else {
            alert(Alert.AlertType.WARNING, error.toString());
            return null;
        }
    }

    public void add(Statue s) {
        try {
            System.out.println(s);
            if (!Api.addStatue(s)) alert(Alert.AlertType.INFORMATION, "Valami okból nem sikerült elmenteni az új szobrot");
            else alert(Alert.AlertType.INFORMATION,"A szobor sikeresen elmentve");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void alert(Alert.AlertType alertType, String text) {
        new Alert(alertType, text, ButtonType.OK).show();
    }
}
