package dev.danvega.Repository;

import dev.danvega.Model.Consultation;
import dev.danvega.Model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Visit findByApotecary_IdAndPatient_IdAndDermatologist_Id(Long apotecary_id, Long medication_id, Long dermatologist_id);

    List<Visit> findByDermatologist_Id(Long dermatologist_id);

    List<Visit> findByApotecary_Id(Long apotecary_id);

    List<Visit> findByApotecary_IdAndDermatologist_Id(Long apotecary_id, Long dermatologist_id);

    List<Visit> findByPatient_Id(Long patient_id);
}
