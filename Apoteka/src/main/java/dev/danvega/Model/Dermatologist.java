package dev.danvega.Model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="dermatologists")
public class Dermatologist extends User{

    @Column(unique = false, nullable = true)
    private Time startHours;

    @Column(unique = false, nullable = true)
    private Time endHours;

    @ManyToOne
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    @OneToMany(mappedBy = "dermatologist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DermatologistRating> ratings;

    @OneToMany(mappedBy = "dermatologist", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Visit> visits;

    @OneToMany(mappedBy = "dermatologist", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<VacationDermatologist> vacations;

    public Dermatologist(Long id, String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstname, lastname, username, password, email, adress, city, country, phone);
    }

    public Dermatologist(String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(firstname, lastname, username, password, email, adress, city, country, phone);
    }

    public Dermatologist() {
    }



    public Dermatologist(String firstname, String lastname, Apotecary apotecary) {
        super(firstname, lastname);
        this.apotecary = apotecary;
    }

    //IZBRISI KAD DOVRSIMO BACKEND OVO SAMO SLUZI DA SE NE CRVENI KOD ZA PRVI SPRINT STO SMO RADILI
    public Dermatologist(String firstname, String lastname, String username, String password, String email) {
        super(firstname, lastname, username, password, email);
    }

    public Dermatologist(String name, String lastName, String city, String address, String phone, String country) {

    }

    public Dermatologist(String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone, Time startHours, Time endHours) {
        super(firstname, lastname, username, password, email, adress, city, country, phone);
        this.startHours = startHours;
        this.endHours = endHours;
    }

    public Dermatologist(Long id, String name, String lastName, String city, String address, String phone, String country) {
        super(id,name,lastName,city,address,phone,country);
    }

    public Dermatologist(Long id, String newPassword) {
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

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }

    public List<DermatologistRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<DermatologistRating> ratings) {
        this.ratings = ratings;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
