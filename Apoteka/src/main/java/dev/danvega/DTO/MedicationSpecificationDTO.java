package dev.danvega.DTO;

import dev.danvega.Model.Medication;

import javax.persistence.*;

public class MedicationSpecificationDTO {

    private String contradictions;
    private String composition;
    private String dailyIntake;
    private String replacementDrugs;

    private Long medication_id;

    public MedicationSpecificationDTO(String contradictions, String composition, String dailyIntake, String replacementDrugs, Long medication_id) {
        this.contradictions = contradictions;
        this.composition = composition;
        this.dailyIntake = dailyIntake;
        this.replacementDrugs = replacementDrugs;
        this.medication_id = medication_id;
    }

    public MedicationSpecificationDTO() {
    }

    public String getContradictions() {
        return contradictions;
    }

    public void setContradictions(String contradictions) {
        this.contradictions = contradictions;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getDailyIntake() {
        return dailyIntake;
    }

    public void setDailyIntake(String dailyIntake) {
        this.dailyIntake = dailyIntake;
    }

    public String getReplacementDrugs() {
        return replacementDrugs;
    }

    public void setReplacementDrugs(String replacementDrugs) {
        this.replacementDrugs = replacementDrugs;
    }

    public Long getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }
}
