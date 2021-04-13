package dev.danvega.Repository;

import dev.danvega.Model.Alergies;
import dev.danvega.Model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findByApotecary_IdAndPatient_IdAndPharmacist_Id(Long user_id, Long medication_id, Long pharmacist_id);
}
