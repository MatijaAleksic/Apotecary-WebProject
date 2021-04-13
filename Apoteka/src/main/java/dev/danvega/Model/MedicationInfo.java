package dev.danvega.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="medicationInfo")
public class MedicationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private double price;

    @Column(unique = false, nullable = true)
    private LocalDate priceDurationEndDate;

    @Column(unique = false, nullable = true)
    private LocalTime priceDurationEndTime;

    @Column(unique = false, nullable = true)
    private int inStorage;

    @OneToOne(mappedBy = "medicationInfo", cascade = CascadeType.ALL)
    private MedicationReservation medicationReservation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apotecary_id")
    private Apotecary apotecary;



    public MedicationInfo() {
    }

    public MedicationInfo(Long id, double price, LocalDate priceDurationEndDate, LocalTime priceDurationEndTime, int inStorage, MedicationReservation medicationReservation, Medication medication, Apotecary apotecary) {
        this.id = id;
        this.price = price;
        this.priceDurationEndDate = priceDurationEndDate;
        this.priceDurationEndTime = priceDurationEndTime;
        this.inStorage = inStorage;
        this.medicationReservation = medicationReservation;
        this.medication = medication;
        this.apotecary = apotecary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStorage() {
        return inStorage;
    }

    public void setInStorage(int inStorage) {
        this.inStorage = inStorage;
    }

    public MedicationReservation getMedicationReservation() {
        return medicationReservation;
    }

    public void setMedicationReservation(MedicationReservation medicationReservation) {
        this.medicationReservation = medicationReservation;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
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
}
