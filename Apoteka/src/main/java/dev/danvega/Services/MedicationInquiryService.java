package dev.danvega.Services;

import dev.danvega.Model.MedicationInfo;
import dev.danvega.Model.MedicationInquiry;
import dev.danvega.Repository.MedicationInfoRepository;
import dev.danvega.Repository.MedicationInquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationInquiryService implements ServiceInterface<MedicationInquiry> {

    @Autowired
    private MedicationInquiryRepository medicationInquiryRepository;

    @Override
    public List<MedicationInquiry> findAll() {
        return medicationInquiryRepository.findAll();
    }

    public Page<MedicationInquiry> findAll(Pageable pageable) {
        return medicationInquiryRepository.findAll(pageable);
    }

    public List<MedicationInquiry> findAllByApotecaryId(Long id) {
        return medicationInquiryRepository.findByApotecary_Id(id);
    }

    @Override
    public MedicationInquiry findOne(Long id) {
        return medicationInquiryRepository.findById(id).orElse(null);
    }


    public MedicationInquiry findByApotecary_IdAndMedication_Id(Long id, Long id1) {
        return medicationInquiryRepository.findByApotecary_IdAndMedication_Id(id, id1);
    }

    public List<MedicationInquiry> findByApotecary_Id(Long id) {
        return medicationInquiryRepository.findByApotecary_Id(id);
    }

    @Override
    public MedicationInquiry create(MedicationInquiry entity) throws Exception {
        if(medicationInquiryRepository.findByApotecary_IdAndMedication_Id(entity.getApotecary().getId(), entity.getMedication().getId()) != null){
            throw new Exception("Medication info for given apotecary and medication already exists");
        }
        return medicationInquiryRepository.save(entity);
    }

    @Override
    public MedicationInquiry update(MedicationInquiry entity, Long id) throws Exception {
        MedicationInquiry existingMedicationInquiry =  medicationInquiryRepository.findById(id).orElse(null);
        if(existingMedicationInquiry == null){
            throw new Exception("Medication inquiry with given id doesn't exist");
        }
        existingMedicationInquiry.setQuantity(entity.getQuantity());
        existingMedicationInquiry.setMedication(entity.getMedication());
        existingMedicationInquiry.setApotecary(entity.getApotecary());

        return medicationInquiryRepository.save(existingMedicationInquiry);
    }

    @Override
    public void delete(Long id) throws Exception {
        MedicationInquiry existingMedicationInquiry = medicationInquiryRepository.findById(id).orElse(null);
        if(existingMedicationInquiry == null){
            throw new Exception("Medication inquiry with given id doesn't exist");
        }
        medicationInquiryRepository.delete(existingMedicationInquiry);
    }
}
