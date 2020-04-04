package org.mirrane.service;

import org.mirrane.dao.SpecialtyDao;
import org.mirrane.dao.SpecialtyDaoImp;
import org.mirrane.entity.Patient;
import org.mirrane.entity.Specialty;

import java.util.List;

public class SpecialtyService {
    SpecialtyDao specialtyDao;
    public SpecialtyService(){
        this.specialtyDao = new SpecialtyDaoImp();
    }

    public void addSpecialty(Specialty specialty) {
        specialtyDao.addSpecialty(specialty);
    }

    public List<Specialty> getSpecialties() {
        return specialtyDao.getSpecialties();
    }

    public Specialty getSpecialty(Integer id) {
        Specialty specialty;

        if (specialtyDao.isPresent(id)) {
            specialty = specialtyDao.getSpecialty(id);
        } else {
           specialty = new Specialty("0","0");
        }

        return specialty;
    }

    public void updateSpecialty(Specialty specialty) {
        if (specialtyDao.isPresent(specialty.getId())) {
            specialtyDao.updateSpecialty(specialty);
        } else {
            specialtyDao.addSpecialty(specialty);
        }
    }

    public void deleteSpecialty(Integer id) {
        Specialty specialty = getSpecialty(id);
        if (!specialty.getId().equals(0)){
            specialtyDao.deleteSpecialty(specialty);
        }
    }

    public boolean isPresent(int id) {
        return specialtyDao.isPresent(id);
    }
}
