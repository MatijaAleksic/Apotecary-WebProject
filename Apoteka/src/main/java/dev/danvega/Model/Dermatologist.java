package dev.danvega.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="dermatologists")
public class Dermatologist extends User{

    @Column(unique = false, nullable = true)
    private LocalDate startHours;

    @Column(unique = false, nullable = true)
    private LocalDate endHours;

    public Dermatologist(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Dermatologist() {
    }

    //IZBRISI KAD DOVRSIMO BACKEND OVO SAMO SLUZI DA SE NE CRVENI KOD ZA PRVI SPRINT STO SMO RADILI
    public Dermatologist(String firstName, String lastname, String username, String password, String email) {
        super(firstName, lastname, username, password, email);
    }

    public LocalDate getStartHours() {
        return startHours;
    }

    public void setStartHours(LocalDate startHours) {
        this.startHours = startHours;
    }

    public LocalDate getEndHours() {
        return endHours;
    }

    public void setEndHours(LocalDate endHours) {
        this.endHours = endHours;
    }
}
