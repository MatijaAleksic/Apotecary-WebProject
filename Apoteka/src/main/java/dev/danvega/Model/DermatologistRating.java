package dev.danvega.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dermatologist_ratings")
public class DermatologistRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dermatologist_id")
    private Dermatologist dermatologist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public DermatologistRating(double rating) {
        this.rating = rating;
    }

    public DermatologistRating(double rating, Dermatologist dermatologist, Patient patient) {
        this.rating = rating;
        this.dermatologist = dermatologist;
        this.patient = patient;
    }

    public DermatologistRating() {
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}