package dev.danvega.Repository;

import dev.danvega.Model.Alergies;
import dev.danvega.Model.Consultation;
import dev.danvega.Model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findByApotecary_IdAndPatient_IdAndPharmacist_Id(Long user_id, Long medication_id, Long pharmacist_id);
    List<Consultation> findByPharmacist_Id(Long pharmacist_id);
}
