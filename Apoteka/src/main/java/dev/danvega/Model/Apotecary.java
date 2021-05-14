package dev.danvega.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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


    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<Dermatologist> dermatologists;

    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<Administrator> administrators;

    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<Pharmacist> pharmacist;


    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<Visit> visits;

    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<ApotecaryRating> apotecaryRatings;

    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<MedicationReservation> medicationReservations;

    @OneToMany(mappedBy = "apotecary", cascade = CascadeType.ALL)
    private List<MedicationInfo> medicationInfos;

//INSERT INTO dermatologists(id, first_name, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (2,'c','dasdf','dasdf','ae','ff','g','h','i','j','8:00:00','16:00:00',1);
    public Apotecary(Long id, String name, String adress, String description, Set<Dermatologist> dermatologists) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
    }

    public Apotecary(Long id, String name, String adress, String description) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
    }

    public Apotecary() {
    }

    public Apotecary(Long id, String name, String adress, String description, List<Dermatologist> dermatologists, List<Administrator> administrators, List<Pharmacist> pharmacist, List<Consultation> consultations, List<Visit> visits, List<ApotecaryRating> apotecaryRatings, List<MedicationReservation> medicationReservations, List<MedicationInfo> medicationInfos) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.description = description;
        this.dermatologists = dermatologists;
        this.administrators = administrators;
        this.pharmacist = pharmacist;
        this.consultations = consultations;
        this.visits = visits;
        this.apotecaryRatings = apotecaryRatings;
        this.medicationReservations = medicationReservations;
        this.medicationInfos = medicationInfos;
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

    public List<Dermatologist> getDermatologists() {
        return dermatologists;
    }

    public void setDermatologists(List<Dermatologist> dermatologists) {
        this.dermatologists = dermatologists;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public List<Pharmacist> getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(List<Pharmacist> pharmacist) {
        this.pharmacist = pharmacist;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<ApotecaryRating> getApotecaryRatings() {
        return apotecaryRatings;
    }

    public void setApotecaryRatings(List<ApotecaryRating> apotecaryRatings) {
        this.apotecaryRatings = apotecaryRatings;
    }

    public List<MedicationReservation> getMedicationReservations() {
        return medicationReservations;
    }

    public void setMedicationReservations(List<MedicationReservation> medicationReservations) {
        this.medicationReservations = medicationReservations;
    }

    public List<MedicationInfo> getMedicationInfos() {
        return medicationInfos;
    }

    public void setMedicationInfos(List<MedicationInfo> medicationInfos) {
        this.medicationInfos = medicationInfos;
    }
}
