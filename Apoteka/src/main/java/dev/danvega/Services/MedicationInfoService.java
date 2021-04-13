package dev.danvega.Services;

import dev.danvega.Model.Alergies;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Repository.AlergiesRepository;
import dev.danvega.Repository.MedicationInfoRepository;
import dev.danvega.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationInfoService  implements ServiceInterface<MedicationInfo> {

    @Autowired
    private MedicationInfoRepository medicationInfoRepository;

    @Override
    public List<MedicationInfo> findAll() {
        return medicationInfoRepository.findAll();
    }

    public Page<MedicationInfo> findAll(Pageable pageable) {
        return medicationInfoRepository.findAll(pageable);
    }

    @Override
    public MedicationInfo findOne(Long id) {
        return medicationInfoRepository.findById(id).orElse(null);
    }

    @Override
    public MedicationInfo create(MedicationInfo entity) throws Exception {
        if(medicationInfoRepository.findByApotecary_IdAndMedication_Id(entity.getApotecary().getId(), entity.getMedication().getId()) != null){
            throw new Exception("Medication info for given apotecary and medication already exists");
        }
        return medicationInfoRepository.save(entity);
    }

    @Override
    public MedicationInfo update(MedicationInfo entity, Long id) throws Exception {
        MedicationInfo existingMedicationInfo =  medicationInfoRepository.findById(id).orElse(null);
        if(existingMedicationInfo == null){
            throw new Exception("Medication info with given id doesn't exist");
        }
        existingMedicationInfo.setInStorage(entity.getInStorage());
        existingMedicationInfo.setPrice(entity.getPrice());
        existingMedicationInfo.setPriceDurationEndDate(entity.getPriceDurationEndDate());
        existingMedicationInfo.setPriceDurationEndTime(entity.getPriceDurationEndTime());

        if(medicationInfoRepository.findByApotecary_IdAndMedication_Id(entity.getApotecary().getId(), entity.getMedication().getId()) != null){
            throw new Exception("Medication info for given apotecary and medication already exists");
        }
        return medicationInfoRepository.save(existingMedicationInfo);
    }

    @Override
    public void delete(Long id) throws Exception {
        MedicationInfo existingMedicationInfo = medicationInfoRepository.findById(id).orElse(null);
        if(existingMedicationInfo == null){
            throw new Exception("Medication info with given id doesn't exist");
        }
        medicationInfoRepository.delete(existingMedicationInfo);
    }
}
