package dev.danvega.Repository;

import dev.danvega.Model.Administrator;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.pattern.PathPattern;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByEmail(String email);

    Patient findByUsername(String username);

    Patient findByUsernameAndPassword(String username, String password);

    Patient findByUsernameAndEmail(String username, String email);


}
