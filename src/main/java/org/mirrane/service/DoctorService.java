package org.mirrane.service;

import org.mirrane.dao.DoctorDao;
import org.mirrane.dao.DoctorDaoImp;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Patient;

import java.util.List;

public class DoctorService {
    DoctorDao doctorDao;
    public  DoctorService(){
        this.doctorDao = new DoctorDaoImp();
    }

    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctorDao.getDoctors();
    }

    public Doctor getDoctor(Integer id) {

        Doctor doctor;

        if (doctorDao.isPresent(id)) {
            doctor = doctorDao.getDoctor(id);
        } else {
           doctor = new Doctor("0","0","0","0",0,"0","not found");
        }

        return doctor;
    }

    public void updateDoctor(Doctor doctor) {

        if (doctorDao.isPresent(doctor.getId())) {
            doctorDao.updateDoctor(doctor);
        } else {
            doctorDao.addDoctor(doctor);
        }
    }

    public void deleteDoctor(Integer id) {

         Doctor doctor = getDoctor(id);
        if (!doctor.getId().equals(0)){
            doctorDao.deleteDoctor(doctor);
        }
    }

    public Doctor getDoctorByCin(String cin) {
        return doctorDao.getDoctorByCin(cin);
    }

    public boolean isPresent(int id) {

        return doctorDao.isPresent(id);
    }
}
