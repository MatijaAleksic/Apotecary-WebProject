package dev.danvega.Repository;

import dev.danvega.Model.ApotecaryRating;
import dev.danvega.Model.DermatologistRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DermatologistRatingRepository extends JpaRepository<DermatologistRating, Long> {

    DermatologistRating findByDermatologist_IdAndPatient_Id(Long dermatologist_id, Long medication_id);

    List<DermatologistRating> findByDermatologist_Id(Long dermatologist_id);

}
