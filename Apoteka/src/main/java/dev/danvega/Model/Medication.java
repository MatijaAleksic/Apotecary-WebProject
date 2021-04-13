package dev.danvega.Model;

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
    private MedicationType Type;

    @Column(unique = false, nullable = true)
    private String specification;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private List<Alergies> alergies;

    @OneToOne(mappedBy = "medication", cascade = CascadeType.ALL)
    private MedicationInfo medicationInfo;

    @OneToOne(mappedBy = "medication", cascade = CascadeType.ALL)
    private MedicationSpecification medicationSpecification;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private List<MedicationRating> ratings;

    public Medication(Long id, String name, MedicationType type, String specification) {
        this.id = id;
        this.name = name;
        Type = type;
        this.specification = specification;
    }

    public Medication(Long id, String name, MedicationType type, String specification, List<Alergies> alergies, MedicationInfo medicationInfo, MedicationSpecification medicationSpecification, List<MedicationRating> ratings) {
        this.id = id;
        this.name = name;
        Type = type;
        this.specification = specification;
        this.alergies = alergies;
        this.medicationInfo = medicationInfo;
        this.medicationSpecification = medicationSpecification;
        this.ratings = ratings;
    }

    public Medication() {
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

    public MedicationType getType() {
        return Type;
    }

    public void setType(MedicationType type) {
        Type = type;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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
