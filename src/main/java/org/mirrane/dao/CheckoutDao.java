package org.mirrane.dao;

import org.mirrane.entity.Checkout;

import java.util.List;

public interface CheckoutDao {
    void saveCheckout(Checkout checkout);
    void deleteCheckout(Checkout checkout);
    void updateCheckout(Checkout checkout);
    List<Checkout> findAllCheckout();
    Checkout findCheckout(Object attribut);
    boolean isPresent(Integer id);
}
