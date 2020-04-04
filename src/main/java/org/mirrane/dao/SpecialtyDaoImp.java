package org.mirrane.dao;

import org.mirrane.entity.Assistant;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Specialty;

import javax.persistence.EntityManager;
import java.util.List;

public class SpecialtyDaoImp implements  SpecialtyDao {


    EntityManager entityManager;

    public SpecialtyDaoImp() {
        this.entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
    }

    public void version() {

        entityManager.getTransaction().begin();
        String sql = "select version()";
        String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
        System.out.println(result);
        entityManager.getTransaction().commit();
    }

    @Override
    public void addSpecialty(Specialty specialty) {
        specialty.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(specialty);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Specialty> getSpecialties() {
        entityManager.getTransaction().begin();
        List<Specialty> specialties = entityManager.createQuery("FROM Specialty", Specialty.class).getResultList();
        entityManager.getTransaction().commit();
        return specialties;
    }

    @Override
    public Specialty getSpecialty(Integer id) {
        entityManager.getTransaction().begin();
        Specialty specialty = entityManager.find(Specialty.class, id);
        entityManager.getTransaction().commit();

        return specialty;
    }

    @Override
    public Specialty getSpecialtyReference(String reference) {
        String query = "SELECT Specialty FROM Specialty s WHERE s.refecence='" + reference + "'";
        return (Specialty) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void updateSpecialty(Specialty specialty) {

        entityManager.getTransaction().begin();
        entityManager.merge(specialty);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteSpecialty(Specialty specialty) {

        entityManager.getTransaction().begin();
        entityManager.remove(specialty);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean isPresent(int id) {
       Specialty specialty= entityManager.find(Specialty.class, id);
        if (specialty == null) return false;
        else return true;
    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
}
