package org.mirrane.service;

import org.mirrane.App;
import org.mirrane.dao.AppointementDao;
import org.mirrane.dao.AppointementDaoImpl;
import org.mirrane.entity.*;

import java.util.Date;
import java.util.List;

public class AppointementService {
    AppointementDao appointementDao;

    public Appointement getAppointementById(int id) {
        Appointement appointement;

        if (appointementDao.isPresent(id)) {
            appointement = appointementDao.getAppointementById(id);
        } else {
            appointement = null;
        }

        return appointement;
    }
    public AppointementService() {
        this.appointementDao = new AppointementDaoImpl();
    }
    public int saveAppointement(Appointement appointement){
        Appointement appointementFounded = findAppointementByReference(appointement.getReference());
        if ( appointementFounded == null) {
            appointement.setStateAppointement("waiting");
            appointementDao.saveAppointement(appointement);
            return 1;
        } else return -1;
    }

    public int updateAppointement(Appointement appointement){
        Appointement appointementFounded = findAppointementByReference(appointement.getReference());
        if ( appointementFounded != null) {
            appointementFounded.setDateAppointement(appointement.getDateAppointement());
            appointementFounded.setHourAppointement(appointement.getHourAppointement());
            appointementFounded.setStateAppointement(appointement.getStateAppointement());
            appointementFounded.setTypeAppointement(appointement.getTypeAppointement());
            appointementFounded.setDoctor(appointement.getDoctor());
            appointementDao.updateAppointement(appointementFounded);
            return 1;
        }else return -1;
    }
    public int deleteAppointement(Appointement appointement){
        Appointement appointementFounded = findAppointementByReference(appointement.getReference());
        if ( appointementFounded != null) {
            appointementDao.deleteAppointement(appointement);
            return 1;
        } else return -1;
    }
    public List<Appointement> findAllAppointement(){
        return appointementDao.findAllAppointement();
    }
    public Boolean isPrestent(Appointement appointement){
        return appointementDao.isPresent(appointement.getId());
    }
    Appointement findAppointementByReference(String reference){
        return appointementDao.findAppointementByReference(reference);
    }
    Appointement findAppointementByDateAppointement(Date dateAppointement){
        return appointementDao.findAppointementByDateAppointement(dateAppointement);
    }
    Appointement findAppointementByHourAppointement(Date hourAppointement){
        return appointementDao.findAppointementByHourAppointement(hourAppointement);
    }
    Appointement findAppointementByStateAppointement(String StateAppointement){
        return appointementDao.findAppointementByStateAppointement(StateAppointement);
    }
    Appointement findAppointementByTypeAppointement(TypeAppointement typeAppointement){
        return appointementDao.findAppointementByTypeAppointement(typeAppointement);
    }
    Appointement findAppointementByPatient(Patient patient){
        return appointementDao.findAppointementByPatient(patient);
    }
    Appointement findAppointementByDoctor(Doctor doctor){
        return appointementDao.findAppointementByDoctor(doctor);
    }
}
