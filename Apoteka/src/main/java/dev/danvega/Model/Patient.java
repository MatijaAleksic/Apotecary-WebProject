package dev.danvega.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="patients")
public class Patient extends User {

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<DermatologistRating> dermatologistRatings;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Patient(String firstName, String lastname, String username, String password, String email) {
        super(firstName, lastname, username, password, email);
    }

    public List<DermatologistRating> getDermatologistRatings() {
        return dermatologistRatings;
    }

    public void setDermatologistRatings(List<DermatologistRating> dermatologistRatings) {
        this.dermatologistRatings = dermatologistRatings;
    }
}
