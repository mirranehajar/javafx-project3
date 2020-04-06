package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mirrane.entity.Specialty;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.TypeAppointementService;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Observable;
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
    public void show() throws IOException{
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

    ObservableList<TypeAppointement> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<TypeAppointement> typeAppointements = typeAppointementService.findAllTypeAppointement();
        for(int i=0; i<typeAppointements.size();i++){
            list.add(new TypeAppointement(typeAppointements.get(i).getReference(), typeAppointements.get(i).getLibelle(),typeAppointements.get(i).getPrice()));
        }

        references.setCellValueFactory(new PropertyValueFactory<>("reference"));
        libelles.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        prices.setCellValueFactory(new PropertyValueFactory<>("price"));
        typeAppointementTableView.setItems(list);

    }
}

