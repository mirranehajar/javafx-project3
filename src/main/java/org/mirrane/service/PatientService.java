package org.mirrane.service;

import org.mirrane.dao.PatientDao;
import org.mirrane.dao.PatientDaoImp;
import org.mirrane.entity.Client;
import org.mirrane.entity.Patient;
import org.mirrane.entity.Specialty;
import org.mirrane.entity.TypeAppointement;

import java.util.List;

public class PatientService {
    PatientDao patientDao;

    public PatientService() {
        this.patientDao = new PatientDaoImp();
    }

    public int addPatient(Patient patient) {

        Patient patientFounded = getPatientByCin(patient.getCin());
        if (patientFounded == null) {
            patientDao.addPatient(patient);

            return 1;
        }
        else {
            return -1;
        }
    }

    public List<Patient> getPatients() {
        return patientDao.getPatients();
    }

    public Patient getPatientById(int id) {
        Patient patient;

        if (patientDao.isPresent(id)) {
            patient = patientDao.getPatientById(id);
        } else {
            patient = new Patient("0","0","0","0","0","0");
        }

        return patient;
    }

    public void updatePatient(Patient patient) {
        Patient patientFouded = getPatientByCin(patient.getCin());
        if (patientFouded!=null) {
            patientFouded.setCin(patient.getCin());
            patientFouded.setFirstName(patient.getFirstName());
            patientFouded.setLastName(patient.getLastName());
            patientFouded.setMail(patient.getMail());
            patientFouded.setAddress(patient.getAddress());
            patientFouded.setPhoneNumber(patient.getPhoneNumber());
            patientDao.updatePatient(patientFouded);
        }
    }

    public int deletePatient(Patient patient) {
       Patient patientFounded = getPatientByCin(patient.getCin());
        if (patientFounded!=null){
            patientDao.deletePatient(patient);
            return 1;
        }else {
            return  0;
        }
    }

    public Patient getPatientByCin(String cin) {

        return patientDao.getPatientByCin(cin);
    }

    public boolean isPresent(int id) {
        return patientDao.isPresent(id);
    }
}
