package dev.danvega.DTO;

import dev.danvega.Model.Apotecary;
import dev.danvega.Model.DermatologistRating;

import java.util.List;

public class DermatologistSearchDTO {

    private Apotecary apotecary;
    private String firstname;
    private String lastname;

    public DermatologistSearchDTO() {
    }

    public DermatologistSearchDTO(String firstname, String lastname, Apotecary apotecary, List<DermatologistRating> ratings) {
        this.apotecary = apotecary;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
