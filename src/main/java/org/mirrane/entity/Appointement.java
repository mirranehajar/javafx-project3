package org.mirrane.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "appointement")
public class Appointement  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private String dateAppointement;
    //@Temporal(javax.persistence.TemporalType.TIME)
    private String hourAppointement;
    private String stateAppointement;
    @ManyToOne
    private TypeAppointement typeAppointement;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;

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

    public String getDateAppointement() {
        return dateAppointement;
    }

    public void setDateAppointement(String dateAppointement) {
        this.dateAppointement = dateAppointement;
    }

    public String getHourAppointement() {
        return hourAppointement;
    }

    public void setHourAppointement(String hourAppointement) {
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

    public Appointement(String reference, String dateAppointement, String hourAppointement, TypeAppointement typeAppointement, Patient patient, Doctor doctor) {
        this.reference = reference;
        this.dateAppointement = dateAppointement;
        this.hourAppointement = hourAppointement;
        this.typeAppointement = typeAppointement;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Appointement() {
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

    @Override
    public String toString() {
        return "Appointement{" +
                "reference='" + reference + '\'' +
                ", dateAppointement=" + dateAppointement +
                ", hourAppointement=" + hourAppointement +
                ", stateAppointement='" + stateAppointement + '\'' +
                ", typeAppointement=" + typeAppointement +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
