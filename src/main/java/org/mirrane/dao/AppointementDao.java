package org.mirrane.dao;

import org.mirrane.entity.Appointement;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Patient;
import org.mirrane.entity.TypeAppointement;

import javax.persistence.Temporal;
import java.util.Date;
import java.util.List;

public interface AppointementDao {
    void saveAppointement(Appointement appointement);
    void deleteAppointement(Appointement appointement);
    void updateAppointement(Appointement appointement);
    List<Appointement> findAllAppointement();
    Appointement findAppointementByReference(String reference);
    Appointement findAppointementByDateAppointement(Date dateAppointement);
    Appointement findAppointementByHourAppointement(Date hourAppointement);
    Appointement findAppointementByStateAppointement(String StateAppointement);
    Appointement findAppointementByTypeAppointement(TypeAppointement typeAppointement);
    Appointement findAppointementByPatient(Patient patient);
    Appointement findAppointementByDoctor(Doctor doctor);
    boolean isPresent(Integer id);
}
