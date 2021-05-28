package dev.danvega.Repository;

import dev.danvega.Model.MedicationSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationSpecificationRepository extends JpaRepository<MedicationSpecification, Long> {

    MedicationSpecification findByMedication_Id(Long id);

}
