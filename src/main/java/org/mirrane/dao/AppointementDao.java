package org.mirrane.dao;

import org.mirrane.entity.Appointement;

import java.util.List;

public interface AppointementDao {
    void saveAppointement(Appointement appointement);
    void deleteAppointement(Appointement appointement);
    void updateAppointement(Appointement appointement);
    List<Appointement> findAllAppointement();
    Object findAppointement(Object attribut);
    boolean isPresent(Integer id);
}
