package org.mirrane;

import javafx.fxml.FXML;

import java.io.IOException;

public class RegistrationController {
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
}
