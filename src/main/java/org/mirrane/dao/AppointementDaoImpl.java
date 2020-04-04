package org.mirrane.dao;

import org.mirrane.entity.Appointement;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Patient;
import org.mirrane.entity.TypeAppointement;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class AppointementDaoImpl implements AppointementDao {

    private EntityManager entityManager;
    private Appointement appointement;

    public AppointementDaoImpl() {
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
    public void saveAppointement(Appointement appointement) {
        entityManager.getTransaction().begin();
        entityManager.persist(appointement);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAppointement(Appointement appointement) {
        entityManager.getTransaction().begin();
        entityManager.remove(appointement);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateAppointement(Appointement appointement) {
        entityManager.getTransaction().begin();
        entityManager.merge(appointement);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Appointement> findAllAppointement() {
        entityManager.getTransaction().begin();
        List<Appointement> appointements = entityManager.createQuery("FROM Appointement ", Appointement.class).getResultList();
        entityManager.getTransaction().commit();
        return appointements;
    }

    @Override
    public Appointement findAppointementByReference(String reference) {
        String query = "SELECT Appointement FROM Appointement a WHERE a.reference='" + reference + "'";
        return (Appointement) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public Appointement findAppointementByDateAppointement(Date dateAppointement) {
        return null;
    }

    @Override
    public Appointement findAppointementByHourAppointement(Date hourAppointement) {
        return null;
    }

    @Override
    public Appointement findAppointementByStateAppointement(String StateAppointement) {
        return null;
    }

    @Override
    public Appointement findAppointementByTypeAppointement(TypeAppointement typeAppointement) {
        return null;
    }

    @Override
    public Appointement findAppointementByPatient(Patient patient) {
        return null;
    }

    @Override
    public Appointement findAppointementByDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public boolean isPresent(Integer id) {
        Appointement appointement = entityManager.find(Appointement.class, id);
        if (appointement == null) return false;
        else return true;
    }
}
