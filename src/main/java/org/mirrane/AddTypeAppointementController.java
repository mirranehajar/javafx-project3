package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.TypeAppointementService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class AddTypeAppointementController implements Initializable {



    public TypeAppointementService typeAppointementService ;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXTextField libelle;
    @FXML
    private JFXTextField price;
    @FXML
    private TableView<TypeAppointement> typeAppointementTableView = new TableView<>();
    @FXML
    private javafx.scene.control.TableColumn<TypeAppointement, String> references;
    @FXML
    private javafx.scene.control.TableColumn<TypeAppointement, String> libelles;
    @FXML
    private TableColumn<TypeAppointement, Double> prices;



    public AddTypeAppointementController() {
        this.typeAppointementService = new TypeAppointementService();
    }

    @FXML
    public void save() throws IOException {
        TypeAppointement typeAppointement = new TypeAppointement(reference.getText(), libelle.getText(), new Double(price.getText()));
        typeAppointementService.saveTypeAppointement(typeAppointement);
        App.setRoot("AddTypeAppointement");

    }
    public void show() {
        TypeAppointement selectedTypeAppointement = typeAppointementTableView.getSelectionModel().getSelectedItem();
        libelle.setText(selectedTypeAppointement.getLibelle());
        reference.setText(selectedTypeAppointement.getReference());
        price.setText(String.valueOf(selectedTypeAppointement.getPrice()));
    }
    public void update() throws IOException{
        TypeAppointement typeAppointement = typeAppointementService.findTypeAppointementByReference(reference.getText());
        typeAppointement.setLibelle(libelle.getText());
        typeAppointement.setPrice(new Double(price.getText()));
        typeAppointementService.updateTypeAppointement(typeAppointement);
        System.out.println(typeAppointement);
        App.setRoot("AddTypeAppointement");
    }
    public void delete() throws IOException {
        TypeAppointement selectedTypeAppointement = typeAppointementTableView.getSelectionModel().getSelectedItem();
       int i = typeAppointementService.deleteTypeAppointement(selectedTypeAppointement);
        System.out.println(i);
        System.out.println(selectedTypeAppointement);
        App.setRoot("AddTypeAppointement");
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
    public void switchToSpecialty() throws IOException {
        App.setRoot("Speciality");
    }
    ObservableList<TypeAppointement> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<TypeAppointement> typeAppointements = typeAppointementService.findAllTypeAppointement();
        for (TypeAppointement typeAppointement : typeAppointements) {
            list.add(new TypeAppointement(typeAppointement.getReference(), typeAppointement.getLibelle(), typeAppointement.getPrice()));
        }

        references.setCellValueFactory(new PropertyValueFactory<>("reference"));
        libelles.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        prices.setCellValueFactory(new PropertyValueFactory<>("price"));
        typeAppointementTableView.setItems(list);

    }
}

