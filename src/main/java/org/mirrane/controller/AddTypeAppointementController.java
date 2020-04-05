package org.mirrane.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.TypeAppointementService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class AddTypeAppointementController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    TypeAppointementService typeAppointementService = new TypeAppointementService();
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXTextField libelle;
    @FXML
    private JFXTextField price;

    TypeAppointement typeAppointement = new TypeAppointement(reference.getText(), libelle.getText(), new Double(price.getText()));
    public void save(ActionEvent actionEvent){
        typeAppointementService.saveTypeAppointement(typeAppointement);
    }
    public JFXTextField getReference() {
        return reference;
    }

    public void setReference(JFXTextField reference) {
        this.reference = reference;
    }

    public JFXTextField getLibelle() {
        return libelle;
    }

    public void setLibelle(JFXTextField libelle) {
        this.libelle = libelle;
    }

    public JFXTextField getPrice() {
        return price;
    }

    public void setPrice(JFXTextField price) {
        this.price = price;
    }
}
