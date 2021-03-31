package dev.danvega.Model;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name="visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private LocalTime startDate;

    @Column(unique = false, nullable = true)
    private int duration;

    @Column(unique = false, nullable = true)
    private double price;

    @Column(unique = false, nullable = true)
    private StatusCV status;

    public Visit(Long id, LocalTime startDate, int duration, double price, StatusCV status) {
        this.id = id;
        this.startDate = startDate;
        this.duration = duration;
        this.price = price;
        this.status = status;
    }

    public Visit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalTime startDate) {
        this.startDate = startDate;
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
}
