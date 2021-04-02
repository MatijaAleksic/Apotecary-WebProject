package dev.danvega.Repository;

import dev.danvega.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean findByUsernameAndPassword(String username, String password);

    boolean findByUsername(String username);

    boolean findByPassword(String password);

    Patient findById(long id);
}
