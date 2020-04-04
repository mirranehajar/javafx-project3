package org.mirrane.service;

import org.mirrane.dao.AppointementDao;
import org.mirrane.dao.AppointementDaoImpl;
import org.mirrane.entity.Appointement;

import java.util.List;

public class AppointementService {
    AppointementDao appointementDao;

    public AppointementService() {
        this.appointementDao = new AppointementDaoImpl();
    }
    public int saveAppointement(Appointement appointement){
        appointementDao.saveAppointement(appointement);
        return 1;
    }
    public int updateAppointement(Appointement appointement){
         appointementDao.updateAppointement(appointement);
         return 1;
    }
    public int deleteAppointement(Appointement appointement){
        appointementDao.deleteAppointement(appointement);
        return 1;
    }
    public List<Appointement> findAllAppointement(){
        return appointementDao.findAllAppointement();
    }
    public Boolean isPrestent(Appointement appointement){
        return appointementDao.isPresent(appointement.getId());
    }
}
