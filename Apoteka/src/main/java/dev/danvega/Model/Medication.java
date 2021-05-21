package dev.danvega.Model;

import dev.danvega.Model.Enums.MedicationType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private String name;

    @Column(unique = false, nullable = true)
    private MedicationType medicationType;

    @OneToMany(mappedBy = "medication", fetch = FetchType.LAZY)
    private List<Alergies> alergies;

    @OneToOne(mappedBy = "medication", fetch = FetchType.LAZY)
    private MedicationInfo medicationInfo;

    @OneToOne(mappedBy = "medication", fetch = FetchType.LAZY)
    private MedicationSpecification medicationSpecification;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MedicationRating> ratings;

    public Medication(Long id, String name, MedicationType type) {
        this.id = id;
        this.name = name;
        this.medicationType = type;
    }

    public Medication(Long id, String name, MedicationType type, List<Alergies> alergies, MedicationInfo medicationInfo, MedicationSpecification medicationSpecification, List<MedicationRating> ratings) {
        this.id = id;
        this.name = name;
        this.medicationType = type;
        this.alergies = alergies;
        this.medicationInfo = medicationInfo;
        this.medicationSpecification = medicationSpecification;
        this.ratings = ratings;
    }

    public Medication() {
    }

    public Medication(String name, MedicationType medicationType) {
        this.name = name;
        this.medicationType = medicationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setMedicationType(MedicationType medicationType) {
        this.medicationType = medicationType;
    }

    public List<Alergies> getAlergies() {
        return alergies;
    }

    public void setAlergies(List<Alergies> alergies) {
        this.alergies = alergies;
    }

    public MedicationInfo getMedicationInfo() {
        return medicationInfo;
    }

    public void setMedicationInfo(MedicationInfo medicationInfo) {
        this.medicationInfo = medicationInfo;
    }

    public MedicationSpecification getMedicationSpecification() {
        return medicationSpecification;
    }

    public void setMedicationSpecification(MedicationSpecification medicationSpecification) {
        this.medicationSpecification = medicationSpecification;
    }

    public List<MedicationRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<MedicationRating> ratings) {
        this.ratings = ratings;
    }
}
