package org.mirrane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SpecialityController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField reference;
    @FXML
    private TextField libelle;

    public TextField getReference() {
        return reference;
    }

    public void setReference(TextField reference) {
        this.reference = reference;
    }

    public TextField getLibelle() {
        return libelle;
    }

    public void setLibelle(TextField libelle) {
        this.libelle = libelle;
    }
}
