package org.mirrane.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    @OneToOne
    private Appointement nextAppointement;
    @OneToOne
    private Appointement currentAppointement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Appointement getNextAppointement() {
        return nextAppointement;
    }

    public void setNextAppointement(Appointement nextAppointement) {
        this.nextAppointement = nextAppointement;
    }

    public Appointement getCurrentAppointement() {
        return currentAppointement;
    }

    public void setCurrentAppointement(Appointement currentAppointement) {
        this.currentAppointement = currentAppointement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        return Objects.equals(id, checkout.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Checkout(String reference, Appointement nextAppointement, Appointement currentAppointement) {
        this.reference = reference;
        this.nextAppointement = nextAppointement;
        this.currentAppointement = currentAppointement;
    }
}
