package dev.danvega.Model;

import javax.persistence.*;

@Entity
@Table(name="administrators")
public class Administrator extends User {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    public Administrator(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Administrator() {
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }
}
