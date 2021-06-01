package dev.danvega.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class VacationDermatologistDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;
    private String description;
    private Long dermatologist_id;
    private Boolean approdved;

    public VacationDermatologistDTO(Long id, LocalDate startDate, LocalDate finishDate, String description, Long dermatologist_id, Boolean approdved) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.dermatologist_id = dermatologist_id;
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

    public Long getDermatologist_id() {
        return dermatologist_id;
    }

    public void setDermatologist_id(Long dermatologist_id) {
        this.dermatologist_id = dermatologist_id;
    }

    public Boolean getApprodved() {
        return approdved;
    }

    public void setApprodved(Boolean approdved) {
        this.approdved = approdved;
    }
}
