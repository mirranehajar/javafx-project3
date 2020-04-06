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

    public int addSpecialty(Specialty specialty) {
       Specialty specialtyFounded = getSpecialtyReference(specialty.getReference());
        if (specialtyFounded == null) {
            specialtyDao.addSpecialty(specialty);

            return 1;
        }
        else {
            return -1;
        }
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

    public int updateSpecialty(Specialty specialty) {
        Specialty specialtyFounded = getSpecialtyReference(specialty.getReference());
        if (specialtyFounded!=null) {
            specialtyFounded.setLibelle(specialty.getLibelle());
            specialtyFounded.setReference(specialty.getReference());
            specialtyDao.updateSpecialty(specialtyFounded);
            return 1;
        } else {
            return -1;
        }
    }

    public void deleteSpecialty(Specialty specialty) {
        Specialty specialtyFounded = getSpecialtyReference(specialty.getReference());
        if (specialtyFounded!=null){
            specialtyDao.deleteSpecialty(specialty);
        }
    }

    public Specialty getSpecialtyReference(String reference) {
        return specialtyDao.getSpecialtyReference(reference);
    }

    public boolean isPresent(int id) {
        return specialtyDao.isPresent(id);
    }
}
