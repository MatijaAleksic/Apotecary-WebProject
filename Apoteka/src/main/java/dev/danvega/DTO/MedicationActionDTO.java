package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.MedicationInfo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class MedicationActionDTO {

    private Long id;
    private LocalDate actionStartDate;
    private LocalTime actionStartTime;
    private LocalDate actionEndDate;
    private LocalTime actionEndTime;
    private Long medicationInfo_id;
    private int procentage;

    public MedicationActionDTO() {
    }

    public MedicationActionDTO(Long id, LocalDate actionStartDate, LocalTime actionStartTime, LocalDate actionEndDate, LocalTime actionEndTime, Long medicationInfo_id, int procentage) {
        this.id = id;
        this.actionStartDate = actionStartDate;
        this.actionStartTime = actionStartTime;
        this.actionEndDate = actionEndDate;
        this.actionEndTime = actionEndTime;
        this.medicationInfo_id = medicationInfo_id;
        this.procentage = procentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getMedicationInfo_id() {
        return medicationInfo_id;
    }

    public void setMedicationInfo_id(Long medicationInfo_id) {
        this.medicationInfo_id = medicationInfo_id;
    }

    public int getProcentage() {
        return procentage;
    }

    public void setProcentage(int procentage) {
        this.procentage = procentage;
    }
}
