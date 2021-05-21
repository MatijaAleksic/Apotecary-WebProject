package dev.danvega.DTO;

import dev.danvega.Model.Enums.MedicationType;

public class MedicationDTO {

    private String name;
    private int medicationType;

    public MedicationDTO() {
    }

    public MedicationDTO(String name, int medicationType) {
        this.name = name;
        this.medicationType = medicationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(int type) {
        this.medicationType = type;
    }
}
