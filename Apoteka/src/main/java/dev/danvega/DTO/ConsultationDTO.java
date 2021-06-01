package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Enums.StatusCV;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultationDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    private int duration;
    private double price;
    private int status;
    private String report;
    private Long pharmacist_id;
    private Long patient_id;
    private Long apotecary_id;
    private Long medication_reservation_id;

    public ConsultationDTO(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report, Long pharmacist_id, Long patient_id, Long apotecary_id, Long medication_reservation_id) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = status;
        this.report = report;
        this.pharmacist_id = pharmacist_id;
        this.patient_id = patient_id;
        this.apotecary_id = apotecary_id;
        this.medication_reservation_id = medication_reservation_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Long getPharmacist_id() {
        return pharmacist_id;
    }

    public void setPharmacist_id(Long pharmacist_id) {
        this.pharmacist_id = pharmacist_id;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }

    public Long getMedication_reservation_id() {
        return medication_reservation_id;
    }

    public void setMedication_reservation_id(Long medication_reservation_id) {
        this.medication_reservation_id = medication_reservation_id;
    }
}
