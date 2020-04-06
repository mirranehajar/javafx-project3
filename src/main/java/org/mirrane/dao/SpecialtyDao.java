package org.mirrane.dao;

import org.mirrane.entity.Specialty;

import java.util.List;

public interface SpecialtyDao {
    int addSpecialty(Specialty specialty);
    List<Specialty> getSpecialties();
    Specialty getSpecialty(Integer id);
    Specialty getSpecialtyReference(String reference);
    int updateSpecialty(Specialty specialty);
    int deleteSpecialty(Specialty specialty);
    boolean isPresent(int id);
}
