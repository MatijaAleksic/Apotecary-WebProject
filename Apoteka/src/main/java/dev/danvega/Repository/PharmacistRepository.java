package dev.danvega.Repository;

import dev.danvega.Model.Administrator;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    Pharmacist findByEmail(String email);

    List<Pharmacist> findByApotecary_Id(Long id);
    Pharmacist findByUsernameAndPassword(String username, String password);
    Pharmacist findByUsername(String username);

}
