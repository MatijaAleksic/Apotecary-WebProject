package dev.danvega.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="pharmacists")
public class Pharmacist extends User{

    @Column(unique = false, nullable = true)
    private LocalDate startHours;

    @Column(unique = false, nullable = true)
    private LocalDate endHours;

    public Pharmacist(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Pharmacist() {
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

