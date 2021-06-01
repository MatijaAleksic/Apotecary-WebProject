package dev.danvega.Repository;

import dev.danvega.Model.Alergies;
import dev.danvega.Model.ApotecaryRating;
import dev.danvega.Model.DermatologistRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApotecaryRatingRepository extends JpaRepository<ApotecaryRating, Long> {

    ApotecaryRating findByApotecary_IdAndPatient_Id(Long user_id, Long medication_id);

    List<ApotecaryRating> findByApotecary_Id(Long apotecary_id);

}
