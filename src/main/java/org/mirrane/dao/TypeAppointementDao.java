package org.mirrane.dao;

import org.mirrane.entity.TypeAppointement;

import java.util.List;

public interface TypeAppointementDao {
    void saveTypeAppointement(TypeAppointement typeAppointement);
    void deleteTypeAppointement(TypeAppointement typeAppointement);
    void updateTypeAppointement(TypeAppointement typeAppointement);
    List<TypeAppointement> findAllTypeAppointement();
    TypeAppointement findTypeAppointement(Object attribut);
    boolean isPresent(Integer id);
}
