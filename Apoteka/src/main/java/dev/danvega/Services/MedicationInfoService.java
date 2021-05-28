package dev.danvega.Services;

import dev.danvega.Model.Alergies;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Repository.AlergiesRepository;
import dev.danvega.Repository.MedicationInfoRepository;
import dev.danvega.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<MedicationInfo> findAllByApotecaryId(Long id) {
        return medicationInfoRepository.findByApotecary_Id(id);
    }

    @Override
    public MedicationInfo findOne(Long id) {
        return medicationInfoRepository.findById(id).orElse(null);
    }

    //@Transactional
    public MedicationInfo findByApotecary_IdAndMedication_Id(Long id, Long id1) {
        return medicationInfoRepository.findByApotecary_IdAndMedication_Id(id, id1);
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
