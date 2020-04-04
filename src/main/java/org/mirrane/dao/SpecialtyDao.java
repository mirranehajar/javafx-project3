package org.mirrane.dao;

import org.mirrane.entity.Specialty;

import java.util.List;

public interface SpecialtyDao {
    void addSpecialty(Specialty specialty);
    List<Specialty> getSpecialties();
    Specialty getSpecialty(Integer id);
    Specialty getSpecialtyReference(String reference);
    void updateSpecialty(Specialty specialty);
    void deleteSpecialty(Specialty specialty);
    boolean isPresent(int id);
}
