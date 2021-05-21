package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.sql.Time;
import java.time.LocalTime;

public class DermatologistDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String adress;
    private String city;
    private String country;
    private String phone;
    private Long apotecary_id;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime startHours;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime endHours;

    private Long id;

    public DermatologistDTO() {
    }

    public DermatologistDTO(Long id, String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone, Long apotecary_id, LocalTime startHours, LocalTime endHours) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.apotecary_id = apotecary_id;
        this.startHours = startHours;
        this.endHours = endHours;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }

    public LocalTime getStartHours() {
        return startHours;
    }

    public void setStartHours(LocalTime startHours) {
        this.startHours = startHours;
    }

    public LocalTime getEndHours() {
        return endHours;
    }

    public void setEndHours(LocalTime endHours) {
        this.endHours = endHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
