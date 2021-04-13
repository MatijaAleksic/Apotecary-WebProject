package dev.danvega.Repository;

import dev.danvega.Model.DermatologistRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DermatologistRatingRepository extends JpaRepository<DermatologistRating, Long> {
}
