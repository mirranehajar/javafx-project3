package org.mirrane;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXTextField mail;
    @FXML
    private JFXPasswordField password;

    @FXML
    public void switchToRegistration() throws IOException {
        App.setRoot("Registration");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
