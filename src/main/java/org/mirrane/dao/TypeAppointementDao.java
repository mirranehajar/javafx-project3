package org.mirrane.dao;

import org.mirrane.entity.Patient;
import org.mirrane.entity.TypeAppointement;

import java.util.List;

public interface TypeAppointementDao {
    void saveTypeAppointement(TypeAppointement typeAppointement);
    void deleteTypeAppointement(TypeAppointement typeAppointement);
    void updateTypeAppointement(TypeAppointement typeAppointement);
    TypeAppointement getTypeAppointementById(Integer id);
    List<TypeAppointement> findAllTypeAppointement();
    TypeAppointement findTypeAppointementByReference(String reference);
    TypeAppointement findTypeAppointementByLibelle(String libelle);
    TypeAppointement findTypeAppointementByPrice(float price);
    boolean isPresent(Integer id);
}
