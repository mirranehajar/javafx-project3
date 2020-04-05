package org.mirrane.dao;

import org.mirrane.entity.Assistant;
import org.mirrane.entity.Client;
import org.mirrane.entity.Patient;
import org.mirrane.entity.TypeAppointement;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public Patient getPatientById(Integer id) {

        entityManager.getTransaction().begin();
        Patient patient = entityManager.find(Patient.class, id);
        entityManager.getTransaction().commit();

        return patient;
    }

    @Override
    public Patient getPatientByCin(String cin) {
        TypedQuery<Patient> query =  entityManager.createQuery("SELECT p FROM Patient p WHERE p.cin = '" + cin + "'", Patient.class);
        return query.getSingleResult();
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
    public boolean isPresent(Integer id) {
        Patient patient = entityManager.find(Patient.class, id);
        if (patient == null) return false;
        else return true;
    }

    @Override
    protected void finalize() throws Throwable {
        entityManager.close();
        super.finalize();
    }
}
