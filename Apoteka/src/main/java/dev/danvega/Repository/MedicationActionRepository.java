package dev.danvega.Repository;

import dev.danvega.Model.MedicationAction;
import dev.danvega.Model.MedicationInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationActionRepository extends JpaRepository<MedicationAction, Long> {

    MedicationAction findByMedicationInfo_Id(Long medicationInfo_id);
}
