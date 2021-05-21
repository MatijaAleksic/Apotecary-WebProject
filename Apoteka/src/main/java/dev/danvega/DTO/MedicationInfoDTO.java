package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

public class MedicationInfoDTO {

    private double price;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate priceDurationEndDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime priceDurationEndTime;
    private int inStorage;

    private Long apotecary_id;
    private Long medication_id;

    public MedicationInfoDTO() {
    }

    public MedicationInfoDTO(double price, LocalDate priceDurationEndDate, LocalTime priceDurationEndTime, int inStorage, Long apotecary_id, Long medication_id) {
        this.price = price;
        this.priceDurationEndDate = priceDurationEndDate;
        this.priceDurationEndTime = priceDurationEndTime;
        this.inStorage = inStorage;
        this.apotecary_id = apotecary_id;
        this.medication_id = medication_id;
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

    public int getInStorage() {
        return inStorage;
    }

    public void setInStorage(int inStorage) {
        this.inStorage = inStorage;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }
}
