package dev.danvega.Repository;

import dev.danvega.Model.VacationDermatologist;
import dev.danvega.Model.VacationPharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationDermatologistRepository extends JpaRepository<VacationDermatologist, Long> {
}
