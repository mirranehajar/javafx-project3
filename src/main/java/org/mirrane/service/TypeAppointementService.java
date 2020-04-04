package org.mirrane.service;

import org.mirrane.dao.TypeAppointementDao;
import org.mirrane.dao.TypeAppointementDaoImpl;
import org.mirrane.entity.TypeAppointement;

import java.util.List;

public class TypeAppointementService {
    TypeAppointementDao typeAppointementDao;

    public TypeAppointementService() {
        this.typeAppointementDao = new TypeAppointementDaoImpl();
    }
    public int saveTypeAppointement(TypeAppointement typeAppointement){
        typeAppointementDao.saveTypeAppointement(typeAppointement);
        return 1;
    }
    public int updateTypeAppointement(TypeAppointement TypeAppointement){
        typeAppointementDao.updateTypeAppointement(TypeAppointement);
        return 1;
    }
    public int deleteTypeAppointement(TypeAppointement TypeAppointement){
        typeAppointementDao.deleteTypeAppointement(TypeAppointement);
        return 1;
    }
    public List<TypeAppointement> findAllTypeAppointement(){
        return typeAppointementDao.findAllTypeAppointement();
    }
    public Boolean isPrestent(TypeAppointement TypeAppointement){
        return typeAppointementDao.isPresent(TypeAppointement.getId());
    }
    public TypeAppointement findTypeAppointementByReference(String reference){
        return typeAppointementDao.findTypeAppointementByReference(reference);
    }
}
