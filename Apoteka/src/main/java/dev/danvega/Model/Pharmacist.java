package dev.danvega.Model;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pharmacists")
public class Pharmacist extends User{

    @Column(unique = false, nullable = true)
    private Time startHours;

    @Column(unique = false, nullable = true)
    private Time endHours;



    @OneToMany(mappedBy = "pharmacist", fetch = FetchType.LAZY)
    private List<VacationPharmacist> vacations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    @OneToMany(mappedBy = "pharmacist", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<PharmacistRating> ratings;

    @OneToMany(mappedBy = "pharmacist", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Consultation> consultations;


    public Pharmacist(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }


    public Pharmacist() {
    }

    public Pharmacist(String name, String lastName, String city, String address, String phone, String country) {
    }

    public Pharmacist(Long id, String name, String lastName, String city, String address, String phone, String country) {
        super(id,name,lastName,city,address,phone,country);
    }

    public Pharmacist(String oldPassword, String newPassword) {
    }

    public Pharmacist(Long id, String newPassword) {
        super(id,newPassword);
    }

    public Pharmacist(String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone, Time startHours, Time endHours) {
        super(firstname, lastname, username, password, email, adress, city, country, phone);
        this.startHours = startHours;
        this.endHours = endHours;
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Time getStartHours() {
        return startHours;
    }

    public void setStartHours(Time startHours) {
        this.startHours = startHours;
    }

    public Time getEndHours() {
        return endHours;
    }

    public void setEndHours(Time endHours) {
        this.endHours = endHours;
    }

    public List<PharmacistRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<PharmacistRating> ratings) {
        this.ratings = ratings;
    }

    public List<VacationPharmacist> getVacations() {
        return vacations;
    }

    public void setVacations(List<VacationPharmacist> vacations) {
        this.vacations = vacations;
    }
}

