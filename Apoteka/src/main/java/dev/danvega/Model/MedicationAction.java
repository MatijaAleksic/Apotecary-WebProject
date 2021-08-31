package dev.danvega.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="medication_action")
public class MedicationAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(unique = false, nullable = true)
    private LocalDate actionStartDate;

    @JsonFormat(pattern = "HH:mm")
    @Column(unique = false, nullable = true)
    private LocalTime actionStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(unique = false, nullable = true)
    private LocalDate actionEndDate;

    @JsonFormat(pattern = "HH:mm")
    @Column(unique = false, nullable = true)
    private LocalTime actionEndTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_info_id")
    private MedicationInfo medicationInfo;

    @Column(unique = false, nullable = true)
    private int procentage;

    public MedicationAction() {
    }

    public MedicationAction(Long id, LocalDate actionStartDate, LocalTime actionStartTime, LocalDate actionEndDate, LocalTime actionEndTime, MedicationInfo medicationInfo, int procentage) {
        this.id = id;
        this.actionStartDate = actionStartDate;
        this.actionStartTime = actionStartTime;
        this.actionEndDate = actionEndDate;
        this.actionEndTime = actionEndTime;
        this.medicationInfo = medicationInfo;
        this.procentage = procentage;
    }

    public MedicationAction(LocalDate actionStartDate, LocalTime actionStartTime, LocalDate actionEndDate, LocalTime actionEndTime, MedicationInfo medInfo, int procentage) {
        this.actionStartDate = actionStartDate;
        this.actionStartTime = actionStartTime;
        this.actionEndDate = actionEndDate;
        this.actionEndTime = actionEndTime;
        this.medicationInfo = medInfo;
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

    public MedicationInfo getMedicationInfo() {
        return medicationInfo;
    }

    public void setMedicationInfo(MedicationInfo medicationInfo) {
        this.medicationInfo = medicationInfo;
    }

    public int getProcentage() {
        return procentage;
    }

    public void setProcentage(int procentage) {
        this.procentage = procentage;
    }
}
