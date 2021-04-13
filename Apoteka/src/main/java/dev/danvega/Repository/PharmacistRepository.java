package dev.danvega.Repository;

import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    Pharmacist findByEmail(String email);
}
