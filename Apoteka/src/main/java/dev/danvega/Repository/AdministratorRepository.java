

package dev.danvega.Repository;

import dev.danvega.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByFirstName(String name);

    Administrator findByFirstNameAndIdNot(String name, Long id);

    //List<Administrator> findByApotecaryId(Long categoryId);
    //Administrator findByApotecaryIdAndId(Long categoryId, Long id);
}
