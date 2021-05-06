package dev.danvega.Repository;

import dev.danvega.Model.Administrator;
import dev.danvega.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByEmail(String email);

    Patient findByUsername(String username);

    Patient findByUsernameAndPassword(String username, String password);

}
