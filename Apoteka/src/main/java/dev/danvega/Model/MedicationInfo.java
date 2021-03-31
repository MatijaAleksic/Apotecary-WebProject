package dev.danvega.Model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="medicationInfo")
public class MedicationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private double price;

    @Column(unique = false, nullable = true)
    private LocalTime priceDurationEnds;

    @Column(unique = false, nullable = true)
    private int inStorage;

    public MedicationInfo(Long id, double price, LocalTime priceDurationEnds, int inStorage) {
        this.id = id;
        this.price = price;
        this.priceDurationEnds = priceDurationEnds;
        this.inStorage = inStorage;
    }

    public MedicationInfo() {
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

    public LocalTime getPriceDurationEnds() {
        return priceDurationEnds;
    }

    public void setPriceDurationEnds(LocalTime priceDurationEnds) {
        this.priceDurationEnds = priceDurationEnds;
    }

    public int getInStorage() {
        return inStorage;
    }

    public void setInStorage(int inStorage) {
        this.inStorage = inStorage;
    }
}
