package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mirrane.entity.Specialty;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.SpecialtyService;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SpecialityController implements Initializable {


    public SpecialtyService specialtyService;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXTextField libelle;
    @FXML
    private TableView<Specialty> specialtyTableView = new TableView<>();
    @FXML
    private javafx.scene.control.TableColumn<Specialty, String> references;
    @FXML
    private javafx.scene.control.TableColumn<Specialty, String> libelles;

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


    public void delete() throws IOException{
        Specialty specialty = new Specialty();
        specialty.setReference(reference.getText());
    }

    public ObservableList<Specialty> getList() {
        return list;
    }

    public void setList(ObservableList<Specialty> list) {
        this.list = list;
    }

    ObservableList<Specialty> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Specialty> specialties = specialtyService.getSpecialties();
        for(int i=0; i<specialties.size();i++){
            list.add(new Specialty(specialties.get(i).getReference(), specialties.get(i).getLibelle()));
        }

        references.setCellValueFactory(new PropertyValueFactory<>("reference"));
        libelles.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        specialtyTableView.setItems(list);

    }
}
