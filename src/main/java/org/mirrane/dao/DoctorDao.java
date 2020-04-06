package org.mirrane.dao;


import org.mirrane.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    int addDoctor(Doctor doctor);
    List<Doctor> getDoctors();
    Doctor getDoctor(Integer id);
    Doctor getDoctorByCin(String cin);
    Doctor getDoctorByMail(String mail);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(Doctor doctor);
    boolean isPresent(int id);
}
