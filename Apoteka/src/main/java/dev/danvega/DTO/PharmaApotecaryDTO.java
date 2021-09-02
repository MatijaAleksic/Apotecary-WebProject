package dev.danvega.DTO;

public class PharmaApotecaryDTO {
    public Long pharmaId;
    public Long apotecaryId;

    public PharmaApotecaryDTO() {
    }

    public PharmaApotecaryDTO(Long pharmaId, Long apotecaryId) {
        this.pharmaId = pharmaId;
        this.apotecaryId = apotecaryId;
    }

    public Long getPharmaId() {
        return pharmaId;
    }

    public void setPharmaId(Long pharmaId) {
        this.pharmaId = pharmaId;
    }

    public Long getApotecaryId() {
        return apotecaryId;
    }

    public void setApotecaryId(Long apotecaryId) {
        this.apotecaryId = apotecaryId;
    }
}
