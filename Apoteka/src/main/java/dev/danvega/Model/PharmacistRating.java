package dev.danvega.Model;

import javax.persistence.*;

@Entity
@Table(name="pharmacist_ratings")
public class PharmacistRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;



    public PharmacistRating(double rating) {
        this.rating = rating;
    }

    public PharmacistRating() {
    }

    public PharmacistRating(Long id, double rating, Pharmacist pharmacist, Patient patient) {
        this.id = id;
        this.rating = rating;
        this.pharmacist = pharmacist;
        this.patient = patient;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
