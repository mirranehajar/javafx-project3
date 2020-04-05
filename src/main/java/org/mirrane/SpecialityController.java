package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.mirrane.entity.Specialty;
import org.mirrane.service.SpecialtyService;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SpecialityController implements Initializable {


    public SpecialtyService specialtyService;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXTextField libelle;

    public SpecialityController(){this.specialtyService = new SpecialtyService();
   
    }

    @FXML
    public void add() throws IOException {

        Specialty specialty = new Specialty();
        specialty.setLibelle(libelle.getText());
        specialty.setReference(reference.getText());
        specialtyService.addSpecialty(specialty);
        reference = new JFXTextField();
        libelle = new JFXTextField();

    }

    public void edit() throws  IOException{

        Specialty specialty = new Specialty();
        specialty.setLibelle(libelle.getText());
        specialty.setReference(reference.getText());
        specialtyService.updateSpecialty(specialty);
        reference = new JFXTextField();
        libelle = new JFXTextField();

    }

    public void delete() throws IOException{
        Specialty specialty = new Specialty();
        specialty.setReference(reference.getText());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
