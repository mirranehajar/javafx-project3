package org.mirrane.dao;


import org.mirrane.entity.Patient;

import java.util.List;

public interface PatientDao {
    int addPatient(Patient patient);
    List<Patient> getPatients();
    Patient getPatientById(Integer id);
    Patient getPatientByCin(String cin);
    void updatePatient(Patient patient);
    int deletePatient(Patient patient);
    boolean isPresent(Integer id);
}
