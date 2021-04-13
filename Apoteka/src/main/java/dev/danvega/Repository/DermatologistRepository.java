package dev.danvega.Repository;

import dev.danvega.Model.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {

    List<Dermatologist> findByFirstnameAndLastname(String firstname, String lastname);

    List<Dermatologist> findByFirstname(String firstname);

    List<Dermatologist> findByLastname(String lastname);

    Dermatologist findByEmail(String email);

}
