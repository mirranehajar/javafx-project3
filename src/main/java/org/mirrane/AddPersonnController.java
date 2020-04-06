package org.mirrane;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import org.mirrane.entity.Patient;
import org.mirrane.entity.Specialty;
import org.mirrane.service.PatientService;

import java.io.IOException;

public class AddPersonnController {
    PatientService patientService;

    @FXML
    private JFXTextField cin;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField phoneNumber;
    @FXML
    private JFXTextField adresse;


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

    public AddPersonnController(){
        this.patientService=new PatientService();

    }

    @FXML
    public void add() throws IOException {

        Patient patient = new Patient();
        patient.setCin(cin.getText());
        patient.setFirstName(firstName.getText());
        patient.setLastName(lastName.getText());
        patient.setPhoneNumber(phoneNumber.getText());
        patient.setMail(mail.getText());
        patient.setAddress(adresse.getText());

        patientService.addPatient(patient);
        App.setRoot("Speciality");

    }

}
