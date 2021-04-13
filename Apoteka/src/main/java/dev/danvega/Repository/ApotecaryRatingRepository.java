package dev.danvega.Repository;

import dev.danvega.Model.ApotecaryRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApotecaryRatingRepository extends JpaRepository<ApotecaryRating, Long> {
}
