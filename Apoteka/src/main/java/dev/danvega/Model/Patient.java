package dev.danvega.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patients")
public class Patient extends User {

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DermatologistRating> dermatologistRating;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PharmacistRating> pharmacistRating;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ApotecaryRating> apotecaryRating;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MedicationRating> medicationRating;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visit> visits;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MedicationReservation> medicationReservations;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alergies> alergies;

    public Patient() {
    }

    public Patient(String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(firstname, lastname, username, password, email, adress, city, country, phone);
    }


    public Patient(Long id, String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone, List<DermatologistRating> dermatologistRating, List<PharmacistRating> pharmacistRating, List<ApotecaryRating> apotecaryRating, List<MedicationRating> medicationRating, List<Consultation> consultations, List<Visit> visits, List<MedicationReservation> medicationReservations, List<Alergies> alergies) {
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

    public Patient(Long id, String firstname, String lastname, String city, String adress, String phone, String country)
    {
        super(firstname, lastname,city,adress,phone, country);
    }

    public Patient(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Patient(String firstName, String lastname, String username, String password, String email) {
        super(firstName, lastname, username, password, email);
    }

    public Patient(String name, String lastName, String city, String address, String phone, String country) {
    }

    public List<DermatologistRating> getDermatologistRating() {
        return dermatologistRating;
    }

    public void setDermatologistRating(List<DermatologistRating> dermatologistRating) {
        this.dermatologistRating = dermatologistRating;
    }

    public List<PharmacistRating> getPharmacistRating() {
        return pharmacistRating;
    }

    public void setPharmacistRating(List<PharmacistRating> pharmacistRating) {
        this.pharmacistRating = pharmacistRating;
    }

    public List<ApotecaryRating> getApotecaryRating() {
        return apotecaryRating;
    }

    public void setApotecaryRating(List<ApotecaryRating> apotecaryRating) {
        this.apotecaryRating = apotecaryRating;
    }

    public List<MedicationRating> getMedicationRating() {
        return medicationRating;
    }

    public void setMedicationRating(List<MedicationRating> medicationRating) {
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
