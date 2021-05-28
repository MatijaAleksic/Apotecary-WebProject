package dev.danvega.Repository;

import dev.danvega.Model.VacationPharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacationPharmacistRepository extends JpaRepository<VacationPharmacist, Long> {


}
