package org.mirrane.service;

import org.mirrane.dao.PatientDao;
import org.mirrane.dao.PatientDaoImp;
import org.mirrane.entity.Client;
import org.mirrane.entity.Patient;

import java.util.List;

public class PatientService {
    PatientDao patientDao;

    public PatientService() {
        this.patientDao = new PatientDaoImp();
    }

    public void addPatient(Patient patient) {
        patientDao.addPatient(patient);
    }

    public List<Patient> getPatients() {
        return patientDao.getPatients();
    }

    public Patient getPatientById(int id) {
        Patient patient;

        if (patientDao.isPresent(id)) {
            patient = patientDao.getPatientById(id);
        } else {
            patient = new Patient("0","0","0","0",0,"0");
        }

        return patient;
    }

    public void updatePatient(Patient patient) {
        if (patientDao.isPresent(patient.getId())) {
            patientDao.updatePatient(patient);
        } else {
            patientDao.addPatient(patient);
        }
    }

    public void deletePatient(Integer id) {
        Patient patient = getPatientById(id);
        if (!patient.getId().equals(0)){
            patientDao.deletePatient(patient);
        }

    }

    public boolean isPresent(int id) {
        return patientDao.isPresent(id);
    }
}
