package dev.danvega.Repository;

import dev.danvega.Model.Apotecary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApotecaryRepository extends JpaRepository<Apotecary, Long> {

    Apotecary findByName(String name);
}
