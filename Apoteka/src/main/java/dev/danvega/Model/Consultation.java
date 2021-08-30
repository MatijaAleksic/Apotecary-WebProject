package dev.danvega.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Enums.StatusCV;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(unique = false, nullable = true)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @Column(unique = false, nullable = true)
    private int duration;

    @Column(unique = false, nullable = true)
    private double price;

    @Column(unique = false, nullable = true)
    private StatusCV status;

    @Column(unique = false, nullable = true)
    private String report;

    @ManyToOne()
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private MedicationReservation medicationReservation;

    public Consultation() {
    }

    public Consultation(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, StatusCV status, String report, Pharmacist pharmacist, Patient patient, Apotecary apotecary, MedicationReservation medicationReservation) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = status;
        this.report = report;
        this.pharmacist = pharmacist;
        this.patient = patient;
        this.apotecary = apotecary;
        this.medicationReservation = medicationReservation;
    }

    public Consultation(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report, Long pharmacist_id, Long patient_id, Long apotecary_id, Long medication_reservation_id) {
    }

    public Consultation(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report, Pharmacist a, Patient b, Apotecary c, MedicationReservation mc) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = StatusCV.fromInteger(status);
        this.report = report;
        this.pharmacist = a;
        this.patient = b;
        this.apotecary = c;
        this.medicationReservation = mc;
    }

    public Consultation(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report, Pharmacist a, Patient b, Apotecary c) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = StatusCV.fromInteger(status);
        this.report = report;
        this.pharmacist = a;
        this.patient = b;
        this.apotecary = c;
    }

    public Consultation(Long id, LocalDate startDate, LocalTime startTime, int duration, double price, int status, String report) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.price = price;
        this.status = StatusCV.fromInteger(status);
        this.report = report;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StatusCV getStatus() {
        return status;
    }

    public void setStatus(StatusCV status) {
        this.status = status;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }

    public MedicationReservation getMedicationReservation() {
        return medicationReservation;
    }

    public void setMedicationReservation(MedicationReservation medicationReservation) {
        this.medicationReservation = medicationReservation;
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
}
