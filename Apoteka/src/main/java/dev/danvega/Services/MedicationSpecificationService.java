package dev.danvega.Services;

import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationSpecification;
import dev.danvega.Repository.MedicationRepository;
import dev.danvega.Repository.MedicationSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationSpecificationService  implements ServiceInterface<MedicationSpecification>{

    @Autowired
    private MedicationSpecificationRepository medicationSpecificationRepository;

    @Override
    public List<MedicationSpecification> findAll() {
        return medicationSpecificationRepository.findAll();
    }

    public Page<MedicationSpecification> findAll(Pageable pageable) {
        return medicationSpecificationRepository.findAll(pageable);
    }

    @Override
    public MedicationSpecification findOne(Long id) {
        return medicationSpecificationRepository.findById(id).orElse(null);
    }

    public MedicationSpecification findByMedication_Id(Long id) {
        return medicationSpecificationRepository.findByMedication_Id(id);
    }

    @Override
    public MedicationSpecification create(MedicationSpecification entity) throws Exception {
        if(medicationSpecificationRepository.findByMedication_Id(entity.getMedication().getId()) != null){
            throw new Exception("Medication specification with given medication id already exists");
        }
        return medicationSpecificationRepository.save(entity);
    }

    @Override
    public MedicationSpecification update(MedicationSpecification entity, Long id) throws Exception {
        MedicationSpecification existingMedicationSpecification =  medicationSpecificationRepository.findById(id).orElse(null);
        if(medicationSpecificationRepository == null){
            throw new Exception("Medication specification with given id doesn't exist");
        }
        existingMedicationSpecification.setComposition(entity.getComposition());
        existingMedicationSpecification.setContradictions(entity.getContradictions());
        existingMedicationSpecification.setDailyIntake(entity.getDailyIntake());
        existingMedicationSpecification.setReplacementDrugs(entity.getReplacementDrugs());

        if(medicationSpecificationRepository.findByMedication_Id(entity.getMedication().getId()) != null){
            throw new Exception("Medication specification with given medication id already exists");
        }
        return medicationSpecificationRepository.save(existingMedicationSpecification);
    }

    @Override
    public void delete(Long id) throws Exception {
        MedicationSpecification existingMedicationSpecification = medicationSpecificationRepository.findById(id).orElse(null);
        if(existingMedicationSpecification == null){
            throw new Exception("Medication specification with given id doesn't exist");
        }
        medicationSpecificationRepository.delete(existingMedicationSpecification);
    }
}
