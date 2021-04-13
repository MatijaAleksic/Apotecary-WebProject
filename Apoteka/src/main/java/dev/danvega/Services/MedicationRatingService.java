package dev.danvega.Services;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.MedicationRating;
import dev.danvega.Repository.DermatologistRatingRepository;
import dev.danvega.Repository.MedicationRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationRatingService  implements ServiceInterface<MedicationRating>{

    @Autowired
    private MedicationRatingRepository medicationRatingRepository;


    @Override
    public List<MedicationRating> findAll() {
        return medicationRatingRepository.findAll();
    }

    public Page<MedicationRating> findAll(Pageable pageable) {
        return medicationRatingRepository.findAll(pageable);
    }

    @Override
    public MedicationRating findOne(Long id) {
        return medicationRatingRepository.findById(id).orElse(null);
    }

    @Override
    public MedicationRating create(MedicationRating entity) throws Exception {
        if(medicationRatingRepository.findByMedication_IdAndPatient_Id(entity.getMedication().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Medication rating rating with given patient and medication already exists");
        }
        return medicationRatingRepository.save(entity);
    }

    @Override
    public MedicationRating update(MedicationRating entity, Long id) throws Exception {
        MedicationRating existingMedicationRating =  medicationRatingRepository.findById(id).orElse(null);
        if(existingMedicationRating == null){
            throw new Exception("Medication rating rating with given id doesn't exist");
        }
        existingMedicationRating.setRating(entity.getRating());

        if(medicationRatingRepository.findByMedication_IdAndPatient_Id(entity.getMedication().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Medication rating rating with given patient and medication already exists");
        }
        return medicationRatingRepository.save(existingMedicationRating);
    }

    @Override
    public void delete(Long id) throws Exception {

        MedicationRating existingMedicationRating = medicationRatingRepository.findById(id).orElse(null);
        if(existingMedicationRating == null){
            throw new Exception("Medication rating rating with given id doesn't exist");
        }
        medicationRatingRepository.delete(existingMedicationRating);

    }
}
