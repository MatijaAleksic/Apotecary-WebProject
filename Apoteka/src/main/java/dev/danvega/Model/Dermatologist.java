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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    @OneToMany(mappedBy = "dermatologist", cascade = CascadeType.ALL)
    private List<DermatologistRating> ratings;

    public Dermatologist(Long id, String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstname, lastname, username, password, email, adress, city, country, phone);
    }

    public Dermatologist() {
    }

    public Dermatologist(String firstname, String lastname, Apotecary apotecary, List<DermatologistRating> ratings) {
        super(firstname, lastname);
        this.apotecary = apotecary;
        this.ratings = ratings;
    }

    //IZBRISI KAD DOVRSIMO BACKEND OVO SAMO SLUZI DA SE NE CRVENI KOD ZA PRVI SPRINT STO SMO RADILI
    public Dermatologist(String firstname, String lastname, String username, String password, String email) {
        super(firstname, lastname, username, password, email);
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
}
