package dev.danvega.Repository;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.MedicationRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRatingRepository extends JpaRepository<MedicationRating, Long> {

    MedicationRating findByMedication_IdAndPatient_Id(Long medication_id, Long patient_id);

}
