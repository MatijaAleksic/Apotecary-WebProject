package dev.danvega.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administrators")
public class Administrator extends User {

    public Administrator(Long id, String firstName, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        super(id, firstName, lastname, username, password, email, adress, city, country, phone);
    }

    public Administrator() {
    }
}
