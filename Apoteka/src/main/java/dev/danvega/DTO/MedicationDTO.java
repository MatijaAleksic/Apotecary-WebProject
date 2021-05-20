package dev.danvega.DTO;

import dev.danvega.Model.Enums.MedicationType;

public class MedicationDTO {

    private String name;
    private MedicationType medicationType;

    public MedicationDTO() {
    }

    public MedicationDTO(String name, MedicationType medicationType) {
        this.name = name;
        this.medicationType = medicationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicationType getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(MedicationType type) {
        this.medicationType = type;
    }
}
