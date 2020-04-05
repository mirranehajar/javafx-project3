package org.mirrane.service;

import org.mirrane.dao.CheckoutDao;
import org.mirrane.dao.CheckoutDaoImpl;
import org.mirrane.entity.Appointement;
import org.mirrane.entity.Checkout;

import java.util.List;

public class CheckoutService {
    CheckoutDao checkoutDao;
    AppointementService appointementService;

    public CheckoutService() {
        this.checkoutDao = new CheckoutDaoImpl();
    }
    public int saveCheckout(Checkout checkout){
        Checkout checkoutFounded = findCheckoutByReference(checkout.getReference());
        if(checkoutFounded == null){
            Appointement appointementFounded =  appointementService.findAppointementByReference(checkout.getCurrentAppointement().getReference());
            appointementFounded.setStateAppointement("paid");
            appointementService.saveAppointement(checkout.getNextAppointement());
        checkoutDao.saveCheckout(checkout);

        return 1;
        }
        else return -1;
    }

    public int deleteCheckout(Checkout checkout){
        Checkout checkoutFounded = findCheckoutByReference(checkout.getReference());
        if(checkoutFounded != null){
        checkoutDao.deleteCheckout(checkout);
            return 1;
        }
        else return -1;
    }
    public List<Checkout> findAllCheckout(){
        return checkoutDao.findAllCheckout();
    }
    public Boolean isPrestent(Checkout checkout){
        return checkoutDao.isPresent(checkout.getId());
    }
    Checkout findCheckoutByReference(String reference){
        return checkoutDao.findCheckoutByReference(reference);
    }
    Checkout findCheckoutByCurrentAppointement(Appointement appointement){
        return checkoutDao.findCheckoutByCurrentAppointement(appointement);
    }

}
