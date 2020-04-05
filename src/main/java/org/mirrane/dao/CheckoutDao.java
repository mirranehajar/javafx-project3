package org.mirrane.dao;

        import org.mirrane.entity.Appointement;
        import org.mirrane.entity.Checkout;


        import java.util.List;

public interface CheckoutDao {
    void saveCheckout(Checkout checkout);
    void deleteCheckout(Checkout checkout);
    Checkout getCheckoutById(Integer id);
    List<Checkout> findAllCheckout();
    Checkout findCheckoutByReference(String reference);
    Checkout findCheckoutByCurrentAppointement(Appointement appointement);
    boolean isPresent(Integer id);
}
