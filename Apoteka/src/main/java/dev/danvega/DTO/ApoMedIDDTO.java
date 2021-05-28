package dev.danvega.DTO;

public class ApoMedIDDTO {

    private Long apotecary_id;
    private Long medication_id;

    public ApoMedIDDTO() {
    }

    public ApoMedIDDTO(Long apotecary_id, Long medication_id) {
        this.apotecary_id = apotecary_id;
        this.medication_id = medication_id;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }
}
