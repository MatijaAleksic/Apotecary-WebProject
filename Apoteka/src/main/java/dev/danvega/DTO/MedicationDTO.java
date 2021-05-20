package dev.danvega.DTO;

public class MedicationDTO {
    Long id;
    String name;
    String specification;

    public MedicationDTO() {
    }

    public MedicationDTO(Long id, String name, String specification) {
        this.id = id;
        this.name = name;
        this.specification = specification;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
