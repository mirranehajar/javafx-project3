package org.mirrane.dao;

import org.mirrane.entity.Appointement;
import org.mirrane.entity.Checkout;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CheckoutDaoImpl implements CheckoutDao {

    private EntityManager entityManager;

    public CheckoutDaoImpl() {
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
    public void saveCheckout(Checkout checkout) {
        entityManager.getTransaction().begin();
        entityManager.persist(checkout);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCheckout(Checkout checkout) {
        entityManager.getTransaction().begin();
        entityManager.remove(checkout);
        entityManager.getTransaction().commit();
    }

    @Override
    public Checkout getCheckoutById(Integer id) {
        entityManager.getTransaction().begin();
        Checkout checkout = entityManager.find(Checkout.class, id);
        entityManager.getTransaction().commit();

        return checkout;
    }

    @Override
    public List<Checkout> findAllCheckout() {
        entityManager.getTransaction().begin();
        List<Checkout> checkouts = entityManager.createQuery("FROM Checkout ", Checkout.class).getResultList();
        entityManager.getTransaction().commit();
        return checkouts;
    }

    @Override
    public Checkout findCheckoutByReference(String reference) {
        TypedQuery<Checkout> query =  entityManager.createQuery("SELECT c FROM Checkout c WHERE c.reference = '" + reference + "'", Checkout.class);
        return query.getSingleResult();
    }

    @Override
    public Checkout findCheckoutByCurrentAppointement(Appointement appointement) {
        TypedQuery<Checkout> query =  entityManager.createQuery("SELECT c FROM Checkout c WHERE c.currentAppointement = '" + appointement + "'", Checkout.class);
        return query.getSingleResult();
    }

    @Override
    public boolean isPresent(Integer id) {
        Checkout checkout = entityManager.find(Checkout.class, id);
        return checkout != null;
    }
}
