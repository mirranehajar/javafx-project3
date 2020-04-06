package org.mirrane;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.mirrane.entity.*;
import org.mirrane.service.AppointementService;
import org.mirrane.service.DoctorService;
import org.mirrane.service.PatientService;
import org.mirrane.service.TypeAppointementService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class AddAppointementController implements Initializable {

    public AppointementService appointementService;
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXDatePicker dateAppointement =  new JFXDatePicker();
    @FXML
    private JFXTimePicker hourAppointement = new JFXTimePicker();
    @FXML
    private ChoiceBox typeAppointement = new ChoiceBox();
    @FXML
    private ChoiceBox doctor = new ChoiceBox();
    @FXML
    private ChoiceBox patient = new ChoiceBox();
    @FXML
    private TableView<Appointement> appointementTableView = new TableView<>();
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> references;
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> datesAppointement;
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> hoursAppointement;
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> statesAppointement;
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> typesAppointement;
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> doctors;
    @FXML
    private javafx.scene.control.TableColumn<Appointement, String> patients;

    public AddAppointementController() {
        this.appointementService = new AppointementService();
    }



    TypeAppointementService typeAppointementService = new TypeAppointementService();
    PatientService patientService = new PatientService();
    DoctorService doctorService = new DoctorService();

    ObservableList<Appointement> list = FXCollections.observableArrayList();
    ObservableList<String> listTypeAppointement = FXCollections.observableArrayList();
    ObservableList<String> listPatient = FXCollections.observableArrayList();
    ObservableList<String> listDoctor = FXCollections.observableArrayList();

    @FXML
    public void save() throws IOException {
        Appointement appointement =  new Appointement(reference.getText(),dateAppointement.getValue().toString(), hourAppointement.getValue().toString(), typeAppointementService.findTypeAppointementByLibelle(typeAppointement.getValue().toString()),patientService.getPatientByCin(patient.getValue().toString()), doctorService.getDoctorByCin(doctor.getValue().toString()));
        appointementService.saveAppointement(appointement);
        App.setRoot("AddAppointement");
    }
    public void show() throws IOException{
        Appointement selectedAppointement = appointementTableView.getSelectionModel().getSelectedItem();
        reference.setText(selectedAppointement.getReference());
        dateAppointement.setValue(LocalDate.parse(selectedAppointement.getDateAppointement()));
        hourAppointement.setValue(LocalTime.parse(selectedAppointement.getHourAppointement()));
        typeAppointement.setValue(selectedAppointement.getTypeAppointement().getLibelle());
        doctor.setValue(selectedAppointement.getDoctor().getCin());
        patient.setValue(selectedAppointement.getPatient().getCin());

    }
    public void update() throws IOException{
        Appointement appointement = appointementService.findAppointementByReference(reference.getText());
        appointement.setDateAppointement(dateAppointement.getValue().toString());
        appointement.setHourAppointement(hourAppointement.getValue().toString());
        appointement.setTypeAppointement(typeAppointementService.findTypeAppointementByReference(typeAppointement.getValue().toString()));
        appointement.setPatient(patientService.getPatientByCin(patient.getValue().toString()));
        appointement.setDoctor(doctorService.getDoctorByCin(doctor.getValue().toString()));
        appointementService.updateAppointement(appointement);
        System.out.println(typeAppointement);
        App.setRoot("AddTypeAppointemkent");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Appointement> appointements = appointementService.findAllAppointement();
        for(int i=0; i<appointements.size();i++){
            list.add(new Appointement(appointements.get(i).getReference(), appointements.get(i).getDateAppointement(), appointements.get(i).getHourAppointement(), appointements.get(i).getTypeAppointement(), appointements.get(i).getPatient(), appointements.get(i).getDoctor()));
        }
        references.setCellValueFactory(new PropertyValueFactory<>("reference"));
        datesAppointement.setCellValueFactory(new PropertyValueFactory<>("dateAppointement"));
        hoursAppointement.setCellValueFactory(new PropertyValueFactory<>("hourAppointement"));
        statesAppointement.setCellValueFactory(new PropertyValueFactory<>("stateAppointement"));
        typesAppointement.setCellValueFactory(new PropertyValueFactory<>("typeAppointement"));
        patients.setCellValueFactory(new PropertyValueFactory<>("patient"));
        doctors.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        appointementTableView.setItems(list);
        List<TypeAppointement> typeAppointements = typeAppointementService.findAllTypeAppointement();
        List<Patient> patients = patientService.getPatients();
        List<Doctor> doctors = doctorService.getDoctors();
        for(int i=0; i<typeAppointements.size();i++){
            listTypeAppointement.add(typeAppointements.get(i).getLibelle());
        }
        for(int i=0; i<doctors.size();i++){
            listDoctor.add(doctors.get(i).getCin());
        }
        for(int i=0; i<patients.size();i++){
            listPatient.add(patients.get(i).getCin());
        }
        doctor.setItems(listDoctor);
        patient.setItems(listPatient);
        typeAppointement.setItems(listTypeAppointement);
    }
}
