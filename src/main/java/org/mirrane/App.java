package org.mirrane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mirrane.entity.Appointement;
import org.mirrane.entity.TypeAppointement;
import org.mirrane.service.AppointementService;
import org.mirrane.service.DoctorService;
import org.mirrane.service.PatientService;
import org.mirrane.service.TypeAppointementService;

import javax.persistence.EntityManager;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
   /* DoctorService doctorService = new DoctorService();
    TypeAppointementService typeAppointementService = new TypeAppointementService();
    PatientService patientService = new PatientService();
    AppointementService appointementService = new AppointementService();
    Appointement appointement = new Appointement("ref4",null, null, typeAppointementService.findTypeAppointementByLibelle("lib10"),patientService.getPatientByCin("hajar"), doctorService.getDoctorByCin("jkxdj45"));
*/
    



    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("Speciality"));
        stage.setScene(scene);
        stage.show();
    }




   // PatientService  patientService = new PatientService();





      /* TypeAppointementService typeAppointementService = new TypeAppointementService();
       TypeAppointement typeAppointement = new TypeAppointement("ref3","lib1", (double) 12);
       typeAppointementService.saveTypeAppointement(typeAppointement);

       TypeAppointement typeAppointementFounded = typeAppointementService.findTypeAppointementByReference("ref1");
        System.out.println(typeAppointementFounded);*/
/*
        System.out.println("1------------------------------------------------------");

        patientService.addPatient(new Patient(1,"hajar","htdty","hh","jj",06545455454,"fnhtd","hi8"));
        System.out.println("2------------------------------------------------------");
        patientService.getPatients().forEach(patient -> System.out.println(patient.toString()));
        System.out.println("3------------------------------------------------------");
        System.out.println(patientService.getPatientById(3).toString());
        System.out.println("4------------------------------------------------------");
        patientService.updatePatient(new Patient(1,"bb","joooo","haha","jaja",0654540000,"l","h99" ));
        System.out.println("5------------------------------------------------------");
        patientService.deletePatient(1);
        System.out.println("6------------------------------------------------------");
        patientService.getPatients().forEach(patient -> System.out.println(patient.toString()));
*/

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }

}