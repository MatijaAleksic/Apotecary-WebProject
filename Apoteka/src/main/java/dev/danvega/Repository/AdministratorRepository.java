package dev.danvega.Repository;

import dev.danvega.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByUsernameAndPassword(String username, String password);

    Administrator findByEmail(String email);

    Administrator findByUsername(String username);

}
