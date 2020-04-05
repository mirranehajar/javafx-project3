package org.mirrane.dao;

import org.mirrane.entity.Appointement;
import org.mirrane.entity.Doctor;
import org.mirrane.entity.Patient;
import org.mirrane.entity.TypeAppointement;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public Appointement getAppointementById(Integer id) {
        entityManager.getTransaction().begin();
        Appointement Appointement = entityManager.find(Appointement.class, id);
        entityManager.getTransaction().commit();

        return Appointement;
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
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.reference = '" + reference + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public Appointement findAppointementByDateAppointement(Date dateAppointement) {
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.dateAppointement = '" + dateAppointement + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public Appointement findAppointementByHourAppointement(Date hourAppointement) {
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.hourAppointement = '" + hourAppointement + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public Appointement findAppointementByStateAppointement(String StateAppointement) {
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.stateAppointement = '" + StateAppointement + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public Appointement findAppointementByTypeAppointement(TypeAppointement typeAppointement) {
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.typeAppointement = '" + typeAppointement + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public Appointement findAppointementByPatient(Patient patient) {
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.patient = '" + patient + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public Appointement findAppointementByDoctor(Doctor doctor) {
        TypedQuery<Appointement> query =  entityManager.createQuery("SELECT a FROM Appointement a WHERE a.doctor = '" + doctor + "'", Appointement.class);
        return query.getSingleResult();
    }

    @Override
    public boolean isPresent(Integer id) {
        Appointement appointement = entityManager.find(Appointement.class, id);
        return appointement != null;
    }
}
