package dev.danvega.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Enums.StatusCV;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="vacationPharmacist")
public class VacationPharmacist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = false, nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(unique = false, nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
    @Column(unique = false, nullable = true)
    private String description;

    @Column(unique = false, nullable = true)
    private StatusCV approved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacist_id")
    private Pharmacist pharmacist;



    public VacationPharmacist(){

    }

    public VacationPharmacist(Long id, LocalDate startDate, LocalDate finishDate, String description, Pharmacist pharmacist,StatusCV approved) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.pharmacist = pharmacist;
        this.approved = approved;

    }

    public VacationPharmacist(Long id, LocalDate startDate, LocalDate finishDate, String description, StatusCV approved) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.approved = approved;
    }

    public VacationPharmacist(LocalDate startDate, LocalDate finishDate, String description, Pharmacist pharmacist_id, StatusCV approdved) {
    }

    public VacationPharmacist(Long id, LocalDate startDate, LocalDate finishDate, String description, Long pharmacist_id, StatusCV approdved) {
    }

    public StatusCV getApproved() {
        return approved;
    }

    public void setApproved(StatusCV approved) {
        this.approved = approved;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
