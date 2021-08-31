package dev.danvega.Repository;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.MedicationInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationInquiryRepository extends JpaRepository<MedicationInquiry, Long> {

    MedicationInquiry findByApotecary_IdAndMedication_Id(Long apotecary_id, Long medication_id);

    List<MedicationInquiry> findByApotecary_Id(Long apotecary_id);
}
