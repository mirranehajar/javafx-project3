package org.mirrane.service;

import org.mirrane.dao.CheckoutDao;
import org.mirrane.dao.CheckoutDaoImpl;
import org.mirrane.entity.Checkout;

import java.util.List;

public class CheckoutService {
    CheckoutDao checkoutDao;

    public CheckoutService() {
        this.checkoutDao = new CheckoutDaoImpl();
    }
    public int saveCheckout(Checkout checkout){
        checkoutDao.saveCheckout(checkout);
        return 1;
    }
    public int updateCheckout(Checkout checkout){
        checkoutDao.updateCheckout(checkout);
        return 1;
    }
    public int deleteCheckout(Checkout checkout){
        checkoutDao.deleteCheckout(checkout);
        return 1;
    }
    public List<Checkout> findAllCheckout(){
        return checkoutDao.findAllCheckout();
    }
    public Boolean isPrestent(Checkout checkout){
        return checkoutDao.isPresent(checkout.getId());
    }
}
