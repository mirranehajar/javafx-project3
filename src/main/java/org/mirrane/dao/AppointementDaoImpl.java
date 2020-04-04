package org.mirrane.dao;

import org.mirrane.entity.Appointement;

import javax.persistence.EntityManager;
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
    public Appointement findAppointement(Object attribut) {

        return entityManager.find(Appointement , attribut);
    }


    @Override
    public boolean isPresent(Integer id) {
        Appointement appointement = entityManager.find(Appointement.class, id);
        if (appointement == null) return false;
        else return true;
    }
}
