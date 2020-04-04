package org.mirrane.dao;

import org.mirrane.entity.Client;
import org.mirrane.entity.Patient;

import javax.persistence.EntityManager;
import java.util.List;

public class PatientDaoImp implements PatientDao {

    EntityManager entityManager;

    public PatientDaoImp() {
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
    public void addPatient(Patient patient) {
        patient.setId(null);
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Patient> getPatients() {
        entityManager.getTransaction().begin();
        List<Patient> patients = entityManager.createQuery("FROM Patient", Patient.class).getResultList();
        entityManager.getTransaction().commit();
        return patients;
    }

    @Override
    public Patient getPatientById(int id) {

        entityManager.getTransaction().begin();
        Patient patient = entityManager.find(Patient.class, id);
        entityManager.getTransaction().commit();

        return patient;
    }

    @Override
    public void updatePatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletePatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.remove(patient);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean isPresent(int id) {
        Patient patient = entityManager.find(Patient.class, id);
        if (patient == null) return false;
        else return true;
    }
}
