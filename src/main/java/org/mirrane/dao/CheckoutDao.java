package org.mirrane.dao;

import org.mirrane.entity.Appointement;
import org.mirrane.entity.Checkout;

import java.util.List;

public interface CheckoutDao {
    void saveCheckout(Checkout checkout);
    void deleteCheckout(Checkout checkout);
    void updateCheckout(Checkout checkout);
    List<Checkout> findAllCheckout();
    Checkout findCheckoutByReference(String reference);
    Checkout findCheckoutByLibelle(String libelle);
    Checkout findCheckoutByCurrentAppointement(Appointement appointement);
    boolean isPresent(Integer id);
}
