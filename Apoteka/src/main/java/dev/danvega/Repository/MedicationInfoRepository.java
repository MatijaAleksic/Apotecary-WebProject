package dev.danvega.Repository;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationInfoRepository extends JpaRepository<MedicationInfo, Long> {

    MedicationInfo findByApotecary_IdAndMedication_Id(Long apotecary_id, Long medication_id);

    List<MedicationInfo> findByApotecary_Id(Long id);

    MedicationInfo findByMedication_IdAndApotecary_Id(Long medication_id, Long apotecary_id);


}
