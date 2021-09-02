package dev.danvega.DTO;

public class DermaApotecaryDTO {
    public Long getDermaID() {
        return dermaID;
    }

    public void setDermaID(Long dermaID) {
        this.dermaID = dermaID;
    }

    public Long getApotecaryID() {
        return apotecaryID;
    }

    public void setApotecaryID(Long apotecaryID) {
        this.apotecaryID = apotecaryID;
    }

    public Long dermaID;
    public Long apotecaryID;

    public DermaApotecaryDTO(Long dermaID, Long apotecaryID) {
        this.dermaID = dermaID;
        this.apotecaryID = apotecaryID;
    }
    public DermaApotecaryDTO()
    {

    }
}
