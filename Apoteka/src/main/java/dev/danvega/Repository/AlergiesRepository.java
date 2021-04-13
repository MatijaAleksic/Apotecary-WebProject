package dev.danvega.Repository;

import dev.danvega.Model.Alergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlergiesRepository extends JpaRepository<Alergies, Long> {

    Alergies findByPatient_Id(Long id);

    Alergies findByMedication_Id(Long id);

    Alergies findByPatient_IdAndMedication_Id(Long user_id, Long medication_id);
}
