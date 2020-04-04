package org.mirrane.dao;


import org.mirrane.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    void addDoctor(Doctor doctor);
    List<Doctor> getDoctors();
    Doctor getDoctor(Object attribut);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(Doctor doctor);
    boolean isPresent(int id);
}
