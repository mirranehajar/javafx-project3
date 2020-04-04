package org.mirrane.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    @OneToOne
    private Appointement nextAppointement;
    @OneToOne
    private Appointement currentAppointement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Checkout() {
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

    @Override
    public String toString() {
        return "Checkout{" +
                "reference='" + reference + '\'' +
                ", nextAppointement=" + nextAppointement +
                ", currentAppointement=" + currentAppointement +
                '}';
    }
}
