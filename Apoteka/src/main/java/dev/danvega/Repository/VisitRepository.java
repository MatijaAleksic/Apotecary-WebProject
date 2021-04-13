package dev.danvega.Repository;

import dev.danvega.Model.Consultation;
import dev.danvega.Model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Visit findByApotecary_IdAndPatient_IdAndDermatologist_Id(Long user_id, Long medication_id, Long dermatologist_id);

}
