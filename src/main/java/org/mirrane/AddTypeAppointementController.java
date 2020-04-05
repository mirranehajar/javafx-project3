package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.TypeAppointementService;

import java.io.IOException;


public class AddTypeAppointementController {



    TypeAppointementService typeAppointementService ;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXTextField libelle;
    @FXML
    private JFXTextField price;


    @FXML
    public void save() throws IOException {
        TypeAppointement typeAppointement = new TypeAppointement(reference.getText(), libelle.getText(), new Double(price.getText()));
        typeAppointementService.saveTypeAppointement(typeAppointement);

    }

}
