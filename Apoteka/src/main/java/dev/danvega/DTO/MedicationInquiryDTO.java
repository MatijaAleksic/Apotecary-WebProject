package dev.danvega.DTO;

public class MedicationInquiryDTO {
    private Long id;
    private Long medication_id;
    private Long apotecary_id;
    private int quantity;

    public MedicationInquiryDTO() {
    }

    public MedicationInquiryDTO(Long id, Long medication_id, Long apotecary_id, int quantity) {
        this.id = id;
        this.medication_id = medication_id;
        this.apotecary_id = apotecary_id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }

    public Long getApotecary_id() {
        return apotecary_id;
    }

    public void setApotecary_id(Long apotecary_id) {
        this.apotecary_id = apotecary_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
