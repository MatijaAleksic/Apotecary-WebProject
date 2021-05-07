package dev.danvega.Repository;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.PharmacistRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRatingRepository extends JpaRepository<PharmacistRating, Long> {

    PharmacistRating findByPharmacist_IdAndPatient_Id(Long pharmacist_id, Long medication_id);

}