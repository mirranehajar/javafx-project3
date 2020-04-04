package org.mirrane.dao;

import org.mirrane.entity.Client;
import org.mirrane.entity.Patient;

import java.util.List;

public interface PatientDao {
    void addPatient(Patient patient);
    List<Patient> getPatients();
    Patient getPatientById(Integer id);
   void updatePatient(Patient patient);
    void deletePatient(Patient patient);
    boolean isPresent(Integer id);
}
