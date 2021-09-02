package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Medication;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisitTableDTO {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    private int duration;
    private double price;
    private int status;
    private String report;

    private String firstname;
    private String lastname;
    private Long patientId;

    public VisitTableDTO(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report, String firstname, String lastname, Long patientId) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = status;
        this.report = report;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patientId = patientId;
    }

    public VisitTableDTO(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report, String firstname, String lastname) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = status;
        this.report = report;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
