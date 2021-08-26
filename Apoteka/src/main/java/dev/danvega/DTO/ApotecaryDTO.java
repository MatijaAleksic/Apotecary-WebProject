package dev.danvega.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ApotecaryDTO {

    private Long id;

    private String name;

    private String adress;

    private String description;

    private double rating;

    public ApotecaryDTO() {
    }

    public ApotecaryDTO(Long id, String name, String adress, String description, double rating) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
        this.rating = rating;
    }

    public ApotecaryDTO(String name, String adress, String description, double rating) {
        this.name = name;
        this.adress = adress;
        this.description = description;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
