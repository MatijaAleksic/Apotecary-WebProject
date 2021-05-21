package dev.danvega.Model;

import dev.danvega.Model.Enums.StatusMedication;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="medicationReservation")
public class MedicationReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private LocalDate reservationEndDate;

    @Column(unique = false, nullable = true)
    private LocalTime reservationEndTime;

    @Column(unique = false, nullable = true)
    private int quantity;

    @Column(unique = false, nullable = true)
    private StatusMedication status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id")
    private Visit visit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_info_id")
    private MedicationInfo medicationInfo;


    public MedicationReservation() {
    }

    public MedicationReservation(Long id, LocalDate reservationEndDate, LocalTime reservationEndTime, int quantity, StatusMedication status, Consultation consultation, Visit visit, Apotecary apotecary, Patient patient, MedicationInfo medicationInfo) {
        this.id = id;
        this.reservationEndDate = reservationEndDate;
        this.reservationEndTime = reservationEndTime;
        this.quantity = quantity;
        this.status = status;
        this.consultation = consultation;
        this.visit = visit;
        this.apotecary = apotecary;
        this.patient = patient;
        this.medicationInfo = medicationInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StatusMedication getStatus() {
        return status;
    }

    public void setStatus(StatusMedication status) {
        this.status = status;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicationInfo getMedicationInfo() {
        return medicationInfo;
    }

    public void setMedicationInfo(MedicationInfo medicationInfo) {
        this.medicationInfo = medicationInfo;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public LocalTime getReservationEndTime() {
        return reservationEndTime;
    }

    public void setReservationEndTime(LocalTime reservationEndTime) {
        this.reservationEndTime = reservationEndTime;
    }
}
