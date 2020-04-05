package org.mirrane;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.mirrane.service.AppointementService;
import org.mirrane.service.TypeAppointementService;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class AddAppointementController implements Initializable {
    TypeAppointementService typeAppointementService;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXDatePicker dateAppointement;
    @FXML
    private JFXTimePicker hourAppointement;
    @FXML
    private ChoiceBox typeAppointement = new ChoiceBox(FXCollections.observableList(typeAppointementService.findAllTypeAppointement()));
    @FXML
    private ChoiceBox doctor;
    @FXML
    private ChoiceBox patient;
    Date time ;

    LocalDate localDate = dateAppointement.getValue();
    Instant instantDate = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    Date date = Date.from(instantDate);
    LocalTime localTime = hourAppointement.getValue();
    Instant instantHour = Instant.from(localTime.atDate(localDate).atZone(ZoneId.systemDefault()));
    Date hour = Date.from(instantHour);


    AppointementService appointementService = new AppointementService();

    public JFXTextField getReference() {
        return reference;
    }

    public void setReference(JFXTextField reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public ChoiceBox getTypeAppointement() {
        return typeAppointement;
    }

    public void setTypeAppointement(ChoiceBox typeAppointement) {
        this.typeAppointement = typeAppointement;
    }

    public ChoiceBox getDoctor() {
        return doctor;
    }

    public void setDoctor(ChoiceBox doctor) {
        this.doctor = doctor;
    }

    public ChoiceBox getPatient() {
        return patient;
    }

    public void setPatient(ChoiceBox patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
