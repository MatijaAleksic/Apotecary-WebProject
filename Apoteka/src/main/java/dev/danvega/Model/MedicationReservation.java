package dev.danvega.Model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="medicationReservation")
public class MedicationReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private LocalTime reservationEnds;

    @Column(unique = false, nullable = true)
    private int quantity;

    @Column(unique = false, nullable = true)
    private StatusMedication status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private Visit visit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medication_info_id")
    private MedicationInfo medicationInfo;

    public MedicationReservation(Long id, LocalTime reservationEnds, int quantity, StatusMedication status) {
        this.id = id;
        this.reservationEnds = reservationEnds;
        this.quantity = quantity;
        this.status = status;
    }

    public MedicationReservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getReservationEnds() {
        return reservationEnds;
    }

    public void setReservationEnds(LocalTime reservationEnds) {
        this.reservationEnds = reservationEnds;
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
}
