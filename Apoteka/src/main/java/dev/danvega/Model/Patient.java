package dev.danvega.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patients")
public class Patient extends User {

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private DermatologistRating dermatologistRating;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private PharmacistRating pharmacistRating;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private ApotecaryRating apotecaryRating;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private MedicationRating medicationRating;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Visit> visits;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicationReservation> medicationReservations;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Alergies> alergies;

    public Patient() {
    }

    public Patient(Long id, String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone, DermatologistRating dermatologistRating, PharmacistRating pharmacistRating, ApotecaryRating apotecaryRating, MedicationRating medicationRating, List<Consultation> consultations, List<Visit> visits, List<MedicationReservation> medicationReservations, List<Alergies> alergies) {
        super(id, firstname, lastname, username, password, email, adress, city, country, phone);
        this.dermatologistRating = dermatologistRating;
        this.pharmacistRating = pharmacistRating;
        this.apotecaryRating = apotecaryRating;
        this.medicationRating = medicationRating;
        this.consultations = consultations;
        this.visits = visits;
        this.medicationReservations = medicationReservations;
        this.alergies = alergies;
    }

    public Patient(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Patient(String firstName, String lastname, String username, String password, String email) {
        super(firstName, lastname, username, password, email);
    }

    public DermatologistRating getDermatologistRating() {
        return dermatologistRating;
    }

    public void setDermatologistRating(DermatologistRating dermatologistRating) {
        this.dermatologistRating = dermatologistRating;
    }

    public PharmacistRating getPharmacistRating() {
        return pharmacistRating;
    }

    public void setPharmacistRating(PharmacistRating pharmacistRating) {
        this.pharmacistRating = pharmacistRating;
    }

    public ApotecaryRating getApotecaryRating() {
        return apotecaryRating;
    }

    public void setApotecaryRating(ApotecaryRating apotecaryRating) {
        this.apotecaryRating = apotecaryRating;
    }

    public MedicationRating getMedicationRating() {
        return medicationRating;
    }

    public void setMedicationRating(MedicationRating medicationRating) {
        this.medicationRating = medicationRating;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<MedicationReservation> getMedicationReservations() {
        return medicationReservations;
    }

    public void setMedicationReservations(List<MedicationReservation> medicationReservations) {
        this.medicationReservations = medicationReservations;
    }

    public List<Alergies> getAlergies() {
        return alergies;
    }

    public void setAlergies(List<Alergies> alergies) {
        this.alergies = alergies;
    }
}
