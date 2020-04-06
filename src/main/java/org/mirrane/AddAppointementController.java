package org.mirrane;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.mirrane.entity.Appointement;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Patient;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.AppointementService;
import org.mirrane.service.DoctorService;
import org.mirrane.service.PatientService;
import org.mirrane.service.TypeAppointementService;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class AddAppointementController implements Initializable {

    AppointementService appointementService;

    List boxList = new LinkedList<String>();
    @FXML
    private JFXTextField reference;
    @FXML
    private JFXDatePicker dateAppointement =  new JFXDatePicker();
    @FXML
    private JFXTimePicker hourAppointement = new JFXTimePicker();
    @FXML
    private ChoiceBox typeAppointement = new ChoiceBox(FXCollections.observableList(boxList));
    @FXML
    private ChoiceBox doctor = new ChoiceBox();
    @FXML
    private ChoiceBox patient = new ChoiceBox();

    public AddAppointementController() {
        this.appointementService = appointementService;
    }


/*

    LocalDate localDate = dateAppointement.getValue();
    Instant instantDate = Instant.from(localDate);
    Date date = Date.from(instantDate);
    LocalTime localTime = hourAppointement.getValue();
    Instant instantHour = Instant.from(localTime.atDate(localDate));
    Date hour = Date.from(instantHour);*/



    TypeAppointementService typeAppointementService = new TypeAppointementService();
    PatientService patientService = new PatientService();
    DoctorService doctorService = new DoctorService();

    ObservableList<String> listTypeAppointement = FXCollections.observableArrayList();
    ObservableList<String> listPatient = FXCollections.observableArrayList();
    ObservableList<String> listDoctor = FXCollections.observableArrayList();

    @FXML
    public void save(){
        System.out.println(reference.getText());
        System.out.println(dateAppointement.getValue().toString());
        System.out.println(hourAppointement.getValue().toString());
        System.out.println(typeAppointementService.findTypeAppointementByLibelle(typeAppointement.getValue().toString()));
        System.out.println(doctorService.getDoctorByCin(doctor.getValue().toString()));
        System.out.println(patientService.getPatientByCin(patient.getValue().toString()));
Appointement appointement =  new Appointement(reference.getText(),dateAppointement.getValue().toString(), hourAppointement.getValue().toString(), typeAppointementService.findTypeAppointementByLibelle(typeAppointement.getValue().toString()),patientService.getPatientByCin(patient.getValue().toString()), doctorService.getDoctorByCin(doctor.getValue().toString()));
        appointementService.saveAppointement(appointement);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
