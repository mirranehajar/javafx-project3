package org.mirrane;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.mirrane.entity.Assistant;
import org.mirrane.service.AssistantService;
import org.mirrane.service.DoctorService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public AssistantService assistantService;
    public DoctorService doctorService;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXPasswordField password;

    public LoginController() {
        this.assistantService = new AssistantService();
        this.doctorService = new DoctorService();
    }

    @FXML
    public void switchToRegistration() throws IOException {
        App.setRoot("Registration");
    }
    public void connect() {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
