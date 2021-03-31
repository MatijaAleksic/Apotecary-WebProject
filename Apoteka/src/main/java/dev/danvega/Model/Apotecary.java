package dev.danvega.Model;


import javax.persistence.*;

@Entity
@Table(name="apotecaries")
public class Apotecary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = true)
    private String name;

    @Column(unique = false, nullable = true)
    private String adress;

    @Column(unique = false, nullable = true)
    private String description;

    public Apotecary(Long id, String name, String adress, String description) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
    }

    public Apotecary() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
