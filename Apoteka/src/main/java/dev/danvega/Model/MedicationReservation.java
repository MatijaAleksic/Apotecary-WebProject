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
}
