package org.mirrane.service;

import org.mirrane.dao.TypeAppointementDao;
import org.mirrane.dao.TypeAppointementDaoImpl;
import org.mirrane.entity.TypeAppointement;

import java.util.List;

public class TypeAppointementService {
    TypeAppointementDao typeAppointementDao;

    public TypeAppointement getTypeAppointementById(int id) {
        TypeAppointement typeAppointement;

        if (typeAppointementDao.isPresent(id)) {
            typeAppointement = typeAppointementDao.getTypeAppointementById(id);
        } else {
            typeAppointement = null;
        }

        return typeAppointement;
    }
    public TypeAppointementService() {
        this.typeAppointementDao = new TypeAppointementDaoImpl();
    }

    public int saveTypeAppointement(TypeAppointement typeAppointement){
        TypeAppointement typeAppointementFounded = findTypeAppointementByReference(typeAppointement.getReference());
        if (typeAppointementFounded == null) {
            typeAppointementDao.saveTypeAppointement(typeAppointement);

            return 1;
        }
        else {
            return -1;
        }
    }
    public int updateTypeAppointement(TypeAppointement typeAppointement){
        TypeAppointement typeAppointementFounded = findTypeAppointementByReference(typeAppointement.getReference());
        if( typeAppointementFounded!= null){
            typeAppointementFounded.setLibelle(typeAppointement.getLibelle());
            typeAppointementFounded.setPrice(typeAppointement.getPrice());
        typeAppointementDao.updateTypeAppointement(typeAppointement);
            return 1;
        }
        else {
            return -1;
        }
    }
    public int deleteTypeAppointement(TypeAppointement TypeAppointement){
        TypeAppointement typeAppointementFounded = findTypeAppointementByReference(TypeAppointement.getReference());
        if (typeAppointementFounded != null) {
        typeAppointementDao.deleteTypeAppointement(TypeAppointement);
        return 1;
    }
        else {
        return -1;
    }
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
    public TypeAppointement findTypeAppointementByLibelle(String libelle){
        return typeAppointementDao.findTypeAppointementByLibelle(libelle);
    }
}
