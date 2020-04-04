package org.mirrane.dao;

import org.mirrane.entity.Appointement;
import org.mirrane.entity.TypeAppointement;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TypeAppointementDaoImpl implements TypeAppointementDao {

    private EntityManager entityManager;

    public TypeAppointementDaoImpl() {
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
    public void saveTypeAppointement(TypeAppointement typeAppointement) {
        entityManager.getTransaction().begin();
        entityManager.persist(typeAppointement);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteTypeAppointement(TypeAppointement typeAppointement) {
        entityManager.getTransaction().begin();
        entityManager.remove(typeAppointement);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateTypeAppointement(TypeAppointement typeAppointement) {
        entityManager.getTransaction().begin();
        entityManager.merge(typeAppointement);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<TypeAppointement> findAllTypeAppointement() {
        entityManager.getTransaction().begin();
        List<TypeAppointement> typeAppointements = entityManager.createQuery("FROM TypeAppointement ", TypeAppointement.class).getResultList();
        entityManager.getTransaction().commit();
        return typeAppointements;
    }

    @Override
    public TypeAppointement findTypeAppointementByReference(String reference) {
        TypedQuery<TypeAppointement> query =  entityManager.createQuery("SELECT ta FROM TypeAppointement ta WHERE ta.reference = '" + reference + "'", TypeAppointement.class);
        return query.getSingleResult();
    }

    @Override
    public TypeAppointement findTypeAppointementByLibelle(String libelle) {
        return null;
    }

    @Override
    public TypeAppointement findTypeAppointementByPrice(float price) {
        return null;
    }

    @Override
    public boolean isPresent(Integer id) {
        TypeAppointement typeAppointement = entityManager.find(TypeAppointement.class, id);
        if (typeAppointement == null) return false;
        else return true;
    }
}
