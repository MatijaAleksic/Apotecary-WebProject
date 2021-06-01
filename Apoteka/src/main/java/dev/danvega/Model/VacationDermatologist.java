package dev.danvega.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Enums.StatusCV;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vacationDermatologist")
public class VacationDermatologist {
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
    @JoinColumn(name = "dermatologist_id")
    private Dermatologist dermatologist;

    public VacationDermatologist(Long id, LocalDate startDate, LocalDate finishDate, String description, StatusCV approved, Dermatologist dermatologist) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.approved = approved;
        this.dermatologist = dermatologist;
    }

    public VacationDermatologist(Long id, LocalDate startDate,LocalDate finishDate, String description, StatusCV approved)
    {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.approved = approved;
    }

    public VacationDermatologist(Long id, LocalDate startDate, LocalDate finishDate, String description, Long pharmacist_id, Boolean approdved) {
    }

    public VacationDermatologist() {

    }

    public VacationDermatologist(Long id, LocalDate startDate, LocalDate finishDate, String description, Long dermatologist_id, StatusCV valueOf) {
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

    public StatusCV getApproved() {
        return approved;
    }

    public void setApproved(StatusCV approved) {
        this.approved = approved;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public void setDermatologist(Dermatologist dermatologist) {
        this.dermatologist = dermatologist;
    }
}
