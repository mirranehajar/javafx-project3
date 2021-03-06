package org.mirrane.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "typeAppointement")
public class TypeAppointement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    private String libelle;
    private Double price;

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeAppointement(String reference, String libelle, Double price) {
        this.reference = reference;
        this.libelle = libelle;
        this.price = price;
    }

    public TypeAppointement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeAppointement that = (TypeAppointement) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TypeAppointement{" +
                "reference='" + reference + '\'' +
                ", libelle='" + libelle + '\'' +
                ", price=" + price +
                '}';
    }
}
