package dev.danvega.Model;

import javax.persistence.*;

@Entity
@Table(name="medication_ratings")
public class MedicationRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicationRating() {
    }

    public MedicationRating(Long id, double rating, Medication medication, Patient patient) {
        this.id = id;
        this.rating = rating;
        this.medication = medication;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
