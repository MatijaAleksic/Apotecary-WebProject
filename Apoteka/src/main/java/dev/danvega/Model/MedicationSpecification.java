package dev.danvega.Model;

import javax.persistence.*;

@Entity
@Table(name="medication_specification")
public class MedicationSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private String contradictions;

    @Column(unique = false, nullable = true)
    private String composition;

    @Column(unique = false, nullable = true)
    private String dailyIntake;

    @Column(unique = false, nullable = true)
    private String replacementDrugs;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private Medication medication;

    public MedicationSpecification(String contradictions, String composition, String dailyIntake, String replacementDrugs) {
        this.contradictions = contradictions;
        this.composition = composition;
        this.dailyIntake = dailyIntake;
        this.replacementDrugs = replacementDrugs;
    }

    public MedicationSpecification(String contradictions, String composition, String dailyIntake, String replacementDrugs, Medication medication) {
        this.contradictions = contradictions;
        this.composition = composition;
        this.dailyIntake = dailyIntake;
        this.replacementDrugs = replacementDrugs;
        this.medication = medication;
    }

    public MedicationSpecification() {
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

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
}
