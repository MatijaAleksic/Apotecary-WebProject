package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Enums.StatusMedication;

import java.time.LocalDate;
import java.time.LocalTime;

public class MedicationReservationDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private int quantity;
    private int status;
    
    private Long consultationID;
    private Long visitId;

    private String firstname;
    private String lastname;
    private Long patientId;

    public MedicationReservationDTO(Long id, LocalDate reservationEndDate, LocalTime reservationEndTime, int quantity, StatusMedication status, String firstname, String lastname) {
    }

    public MedicationReservationDTO(Long id, LocalDate reservationEndDate, LocalTime reservationEndTime, int quantity,  Long id1, Long id2, String firstname, String lastname) {
        this.id = id;
        this.endDate = reservationEndDate;
        this.endTime = reservationEndTime;
        this.quantity = quantity;
        this.consultationID = id1;
        this.visitId = id2;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(Long consultationID) {
        this.consultationID = consultationID;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
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

    public MedicationReservationDTO(Long id, LocalDate endDate, LocalTime endTime, int quantity, int status, Long consultationID, Long visitId, String firstname, String lastname, Long patientId) {
        this.id = id;
        this.endDate = endDate;
        this.endTime = endTime;
        this.quantity = quantity;
        this.status = status;
        this.consultationID = consultationID;
        this.visitId = visitId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patientId = patientId;
    }
}
