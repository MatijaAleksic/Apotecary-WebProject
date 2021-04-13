package dev.danvega.Repository;

import dev.danvega.Model.MedicationReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationReservationRepository extends JpaRepository<MedicationReservation, Long> {
}
