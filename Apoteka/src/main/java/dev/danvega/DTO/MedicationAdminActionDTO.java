package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedicationAdminActionDTO {
    private Long id;
    private String type;
    private String name;
    private String composition;
    private String contradiction;
    private String dailyIntake;
    private String replacement;
    private int inStorage;
    private double price;
    private int procentage;
    private Long apotecary_id;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate actionStartDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime actionStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate actionEndDate;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime actionEndTime;

    public MedicationAdminActionDTO() {
    }

    public MedicationAdminActionDTO(Long id, String type, String name, String composition, String contradiction, String dailyIntake, String replacement, int inStorage, double price, int procentage, Long apotecary_id, LocalDate actionStartDate, LocalTime actionStartTime, LocalDate actionEndDate, LocalTime actionEndTime) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.composition = composition;
        this.contradiction = contradiction;
        this.dailyIntake = dailyIntake;
        this.replacement = replacement;
        this.inStorage = inStorage;
        this.price = price;
        this.procentage = procentage;
        this.apotecary_id = apotecary_id;
        this.actionStartDate = actionStartDate;
        this.actionStartTime = actionStartTime;
        this.actionEndDate = actionEndDate;
        this.actionEndTime = actionEndTime;
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

    public int getProcentage() {
        return procentage;
    }

    public void setProcentage(int procentage) {
        this.procentage = procentage;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }

    public LocalDate getActionStartDate() {
        return actionStartDate;
    }

    public void setActionStartDate(LocalDate actionStartDate) {
        this.actionStartDate = actionStartDate;
    }

    public LocalTime getActionStartTime() {
        return actionStartTime;
    }

    public void setActionStartTime(LocalTime actionStartTime) {
        this.actionStartTime = actionStartTime;
    }

    public LocalDate getActionEndDate() {
        return actionEndDate;
    }

    public void setActionEndDate(LocalDate actionEndDate) {
        this.actionEndDate = actionEndDate;
    }

    public LocalTime getActionEndTime() {
        return actionEndTime;
    }

    public void setActionEndTime(LocalTime actionEndTime) {
        this.actionEndTime = actionEndTime;
    }
}
