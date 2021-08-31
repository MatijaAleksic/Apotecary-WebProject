package dev.danvega.Services;

import dev.danvega.Model.MedicationAction;
import dev.danvega.Model.MedicationInquiry;
import dev.danvega.Repository.MedicationActionRepository;
import dev.danvega.Repository.MedicationInquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationActionService implements ServiceInterface<MedicationAction> {

    @Autowired
    private MedicationActionRepository medicationActionRepository;

    @Override
    public List<MedicationAction> findAll() {
        return medicationActionRepository.findAll();
    }

    public Page<MedicationAction> findAll(Pageable pageable) {
        return medicationActionRepository.findAll(pageable);
    }

    public MedicationAction findAllByMedicationInfo_id(Long id) {
        return medicationActionRepository.findByMedicationInfo_Id(id);
    }

    @Override
    public MedicationAction findOne(Long id) {
        return medicationActionRepository.findById(id).orElse(null);
    }


    @Override
    public MedicationAction create(MedicationAction entity) throws Exception {
        if(medicationActionRepository.findByMedicationInfo_Id(entity.getMedicationInfo().getId()) != null){
            throw new Exception("Medication action for given medication info already exists");
        }
        return medicationActionRepository.save(entity);
    }

    @Override
    public MedicationAction update(MedicationAction entity, Long id) throws Exception {
        MedicationAction existingMedicationAction =  medicationActionRepository.findById(id).orElse(null);
        if(existingMedicationAction == null){
            throw new Exception("Medication action with given id doesn't exist");
        }
        existingMedicationAction.setActionStartDate(entity.getActionStartDate());
        existingMedicationAction.setActionStartTime(entity.getActionStartTime());
        existingMedicationAction.setActionEndDate(entity.getActionEndDate());
        existingMedicationAction.setActionEndTime(entity.getActionEndTime());
        existingMedicationAction.setProcentage(entity.getProcentage());

        return medicationActionRepository.save(existingMedicationAction);
    }

    @Override
    public void delete(Long id) throws Exception {
        MedicationAction existingMedicationAction = medicationActionRepository.findById(id).orElse(null);
        if(existingMedicationAction == null){
            throw new Exception("Medication action with given id doesn't exist");
        }
        medicationActionRepository.delete(existingMedicationAction);
    }
}
