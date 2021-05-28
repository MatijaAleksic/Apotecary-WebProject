package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

public class MedicationAdminDTO {

    private Long id;
    private String type;
    private String name;
    private String composition;
    private String contradiction;
    private String dailyIntake;
    private String replacement;
    private int inStorage;
    private double price;
    private Long apotecary_id;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate priceDurationEndDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime priceDurationEndTime;

    public MedicationAdminDTO() {
    }

    public MedicationAdminDTO(Long id, String type, String name, String composition, String contradiction, String dailyIntake, String replacement, int inStorage, double price, LocalDate priceDurationEndDate, LocalTime priceDurationEndTime, Long apotecary_id) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.composition = composition;
        this.contradiction = contradiction;
        this.dailyIntake = dailyIntake;
        this.replacement = replacement;
        this.inStorage = inStorage;
        this.price = price;
        this.priceDurationEndDate = priceDurationEndDate;
        this.priceDurationEndTime = priceDurationEndTime;
        this.apotecary_id = apotecary_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getContradiction() {
        return contradiction;
    }

    public void setContradiction(String contradiction) {
        this.contradiction = contradiction;
    }

    public String getDailyIntake() {
        return dailyIntake;
    }

    public void setDailyIntake(String dailyIntake) {
        this.dailyIntake = dailyIntake;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public int getInStorage() {
        return inStorage;
    }

    public void setInStorage(int inStorage) {
        this.inStorage = inStorage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPriceDurationEndDate() {
        return priceDurationEndDate;
    }

    public void setPriceDurationEndDate(LocalDate priceDurationEndDate) {
        this.priceDurationEndDate = priceDurationEndDate;
    }

    public LocalTime getPriceDurationEndTime() {
        return priceDurationEndTime;
    }

    public void setPriceDurationEndTime(LocalTime priceDurationEndTime) {
        this.priceDurationEndTime = priceDurationEndTime;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }
}
