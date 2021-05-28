package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.Model.Pharmacist;

import java.time.LocalDate;

public class VacationPharmacistDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
    private String description;
    private Long pharmacist_id;
    private Boolean approdved;

    public VacationPharmacistDTO(Long id, LocalDate startDate, LocalDate finishDate, String description, Long pharmacist_id, Boolean approdved) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.pharmacist_id = pharmacist_id;
        this.approdved = approdved;
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

    public Long getPharmacist_id() {
        return pharmacist_id;
    }

    public void setPharmacist_id(Long pharmacist_id) {
        this.pharmacist_id = pharmacist_id;
    }

    public Boolean getApprodved() {
        return approdved;
    }

    public void setApprodved(Boolean approdved) {
        this.approdved = approdved;
    }
}
