package dev.danvega.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="medication_inquiry")
public class MedicationInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apotecary_id", nullable = true)
    @JsonIgnore
    private Apotecary apotecary;

    @Column(unique = false, nullable = true)
    private int quantity;

    public MedicationInquiry(){}

    public MedicationInquiry(int quantity, Apotecary apo, Medication med) {
        this.quantity = quantity;
        this.apotecary = apo;
        this.medication = med;
    }

    public MedicationInquiry(int quantity) {
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Apotecary getApotecary() {
        return apotecary;
    }

    public void setApotecary(Apotecary apotecary) {
        this.apotecary = apotecary;
    }
}
