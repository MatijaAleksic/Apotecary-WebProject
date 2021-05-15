package dev.danvega.Repository;

import dev.danvega.Model.Apotecary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApotecaryRepository extends JpaRepository<Apotecary, Long> {

    List<Apotecary> findByNameAndAdress(String name, String address);

    List<Apotecary> findByName(String name);

    List<Apotecary> findByAdress(String address);
}
