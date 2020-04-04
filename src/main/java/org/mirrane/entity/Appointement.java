package org.mirrane.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "appointement")
public class Appointement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAppointement;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date hourAppointement;
    private String stateAppointement;
    @ManyToOne
    private TypeAppointement typeAppointement;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Checkout checkout;

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

    public Date getDateAppointement() {
        return dateAppointement;
    }

    public void setDateAppointement(Date dateAppointement) {
        this.dateAppointement = dateAppointement;
    }

    public Date getHourAppointement() {
        return hourAppointement;
    }

    public void setHourAppointement(Date hourAppointement) {
        this.hourAppointement = hourAppointement;
    }

    public String getStateAppointement() {
        return stateAppointement;
    }

    public void setStateAppointement(String stateAppointement) {
        this.stateAppointement = stateAppointement;
    }

    public TypeAppointement getTypeAppointement() {
        return typeAppointement;
    }

    public void setTypeAppointement(TypeAppointement typeAppointement) {
        this.typeAppointement = typeAppointement;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public Appointement(String reference, Date dateAppointement, Date hourAppointement, String stateAppointement, TypeAppointement typeAppointement, Patient patient, Doctor doctor) {
        this.reference = reference;
        this.dateAppointement = dateAppointement;
        this.hourAppointement = hourAppointement;
        this.stateAppointement = stateAppointement;
        this.typeAppointement = typeAppointement;
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointement that = (Appointement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
