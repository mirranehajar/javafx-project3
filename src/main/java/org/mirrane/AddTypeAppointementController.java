package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.TypeAppointementService;

import java.io.IOException;


public class AddTypeAppointementController {



    public TypeAppointementService typeAppointementService ;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXTextField libelle;
    @FXML
    private JFXTextField price;

    public AddTypeAppointementController() {
        this.typeAppointementService = new TypeAppointementService();
    }

    @FXML
    public void save() throws IOException {
        System.out.println(reference.getText());
        System.out.println(libelle.getText());
        System.out.println(new Double(price.getText()));
        TypeAppointement typeAppointement = new TypeAppointement();
        typeAppointement.setReference(reference.getText());
        typeAppointement.setLibelle(libelle.getText());
        typeAppointement.setPrice(new Double(price.getText()));
        typeAppointementService.saveTypeAppointement(typeAppointement);
        reference = new JFXTextField();
        libelle = new JFXTextField();
        price = new JFXTextField();

    }

}
