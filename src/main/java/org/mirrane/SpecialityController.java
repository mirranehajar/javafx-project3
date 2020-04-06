package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mirrane.entity.Specialty;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.SpecialtyService;

import javax.persistence.NoResultException;
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
    private JFXTextField deleteRef;

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
        App.setRoot("Speciality");

    }


    public void delete() throws IOException {
        Specialty specialty = new Specialty();
        specialtyService.deleteSpecialty(specialty);
        App.setRoot("Speciality");


    }

    public void edit() throws IOException{
        Specialty selectedSpecialty = specialtyTableView.getSelectionModel().getSelectedItem();
        libelle.setText(selectedSpecialty.getLibelle());
        reference.setText(selectedSpecialty.getReference());
    }
    public void edit1() throws IOException{
        Specialty specialty = new Specialty();
        specialty.setLibelle(libelle.getText());
        specialty.setReference(reference.getText());
        specialtyService.updateSpecialty(specialty);
        App.setRoot("Speciality");

    }
    @FXML
    public void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
    @FXML
    public void switchToAppointment() throws IOException {
        App.setRoot("AddAppointement");
    }
    @FXML
    public void switchToAddPerson() throws IOException {
        App.setRoot("AddPerson");
    }
    @FXML
    public void switchToTypeApp() throws IOException {
        App.setRoot("AddTypeAppointement");
    }
    @FXML
    public void switchToRegistration() throws IOException {
        App.setRoot("Registration");
    }
    @FXML
    public void switchToSpecialty() throws IOException {
        App.setRoot("Speciality");
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

