package dev.danvega.Repository;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.MedicationReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationReservationRepository extends JpaRepository<MedicationReservation, Long> {

    MedicationReservation findByApotecary_IdAndPatient_IdAndMedicationInfo_Id(Long apotecary_id, Long patient_id, Long medication_info_id);

}
