package org.mirrane;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mirrane.entity.Patient;
import org.mirrane.entity.Specialty;
import org.mirrane.service.PatientService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddPersonnController implements Initializable {
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
    private JFXTextArea adresse;
    @FXML
    private TableView<Patient> patientTableView = new TableView<>();
    @FXML
    private javafx.scene.control.TableColumn<Patient, String> cins;
    @FXML
    private javafx.scene.control.TableColumn<Patient, String> firstNames;
    @FXML
    private javafx.scene.control.TableColumn<Patient, String> lastNames;
    @FXML
    private javafx.scene.control.TableColumn<Patient, String> mails;
    @FXML
    private javafx.scene.control.TableColumn<Patient, String> phoneNumbers;
    @FXML
    private javafx.scene.control.TableColumn<Patient, String> adresses;


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


    public void delete() throws IOException {
        Patient selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        int i = patientService.deletePatient(selectedPatient);
        System.out.println(i);
        System.out.println(selectedPatient);
        App.setRoot("AddPerson");
    }

    public void edit() throws IOException{
        Patient selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        cin.setText(selectedPatient.getCin());
        firstName.setText(selectedPatient.getFirstName());
        lastName.setText(selectedPatient.getLastName());
        phoneNumber.setText(selectedPatient.getPhoneNumber());
        adresse.setText(selectedPatient.getAddress());
        mail.setText(selectedPatient.getMail());
    }
    public void edit1() throws IOException{
        Patient patient = new Patient();
        patient.setCin(cin.getText());
        patient.setFirstName(firstName.getText());
        patient.setLastName(lastName.getText());
        patient.setMail(mail.getText());
        patient.setPhoneNumber(phoneNumber.getText());
        patient.setAddress(adresse.getText());
        patientService.updatePatient(patient);
        App.setRoot("AddPerson");

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
        App.setRoot("AddPerson");

    }

    public ObservableList<Patient> getList() {
        return list;
    }

    public void setList(ObservableList<Patient> list) {
        this.list = list;
    }

    ObservableList<Patient> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Patient> patients = patientService.getPatients();
        for(int i=0; i<patients.size();i++){
            list.add(new Patient(patients.get(i).getCin(), patients.get(i).getFirstName(), patients.get(i).getLastName(), patients.get(i).getMail(), patients.get(i).getPhoneNumber(),patients.get(i).getAddress()));
        }

        cins.setCellValueFactory(new PropertyValueFactory<>("cin"));
        firstNames.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNames.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        mails.setCellValueFactory(new PropertyValueFactory<>("mail"));
        phoneNumbers.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        adresses.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        patientTableView.setItems(list);


    }
    }

