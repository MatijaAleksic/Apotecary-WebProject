package dev.danvega.Services;

import dev.danvega.Model.Alergies;
import dev.danvega.Model.Medication;
import dev.danvega.Repository.AlergiesRepository;
import dev.danvega.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService  implements ServiceInterface<Medication>{

    @Autowired
    private MedicationRepository medicationRepository;


    @Override
    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    public Page<Medication> findAll(Pageable pageable) {
        return medicationRepository.findAll(pageable);
    }

    @Override
    public Medication findOne(Long id) {
        return medicationRepository.findById(id).orElse(null);
    }

    @Override
    public Medication create(Medication entity) throws Exception {
        if(medicationRepository.findByName(entity.getName()) != null){
            throw new Exception("Medication with given name already exists");
        }
        return medicationRepository.save(entity);
    }

    @Override
    public Medication update(Medication entity, Long id) throws Exception {
        Medication existingMedication =  medicationRepository.findById(id).orElse(null);
        if(existingMedication == null){
            throw new Exception("Medication with given id doesn't exist");
        }
        existingMedication.setMedicationType(entity.getMedicationType());
        existingMedication.setMedicationSpecification(entity.getMedicationSpecification());

        if(medicationRepository.findByName(entity.getName()) != null){
            throw new Exception("Medication with given name already exists");
        }
        return medicationRepository.save(existingMedication);
    }

    @Override
    public void delete(Long id) throws Exception {
        Medication existingMedication = medicationRepository.findById(id).orElse(null);
        if(existingMedication == null){
            throw new Exception("Medication with given id doesn't exist");
        }
        medicationRepository.delete(existingMedication);
    }
}
