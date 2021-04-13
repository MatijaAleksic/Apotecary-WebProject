package dev.danvega.Repository;

import dev.danvega.Model.MedicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationInfoRepository extends JpaRepository<MedicationInfo, Long> {
}
