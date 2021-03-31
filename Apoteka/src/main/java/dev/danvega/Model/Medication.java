package dev.danvega.Model;

import javax.persistence.*;

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

    public Medication(Long id, String name, MedicationType type, String specification) {
        this.id = id;
        this.name = name;
        Type = type;
        this.specification = specification;
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
}
