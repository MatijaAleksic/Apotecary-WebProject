package dev.danvega.Services;

import dev.danvega.Model.MedicationRating;
import dev.danvega.Model.MedicationReservation;
import dev.danvega.Repository.MedicationRatingRepository;
import dev.danvega.Repository.MedicationReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationReservationService implements ServiceInterface<MedicationReservation> {

    @Autowired
    private MedicationReservationRepository medicationReservationRepository;

    @Override
    public List<MedicationReservation> findAll() {
        return medicationReservationRepository.findAll();
    }

    public Page<MedicationReservation> findAll(Pageable pageable) {
        return medicationReservationRepository.findAll(pageable);
    }

    public List<MedicationReservation> findByApotecaryId(Long id){
        return medicationReservationRepository.findByApotecary_Id(id);
    }

    @Override
    public MedicationReservation findOne(Long id) {
        return medicationReservationRepository.findById(id).orElse(null);
    }

    @Override
    public MedicationReservation create(MedicationReservation entity) throws Exception {
        if(medicationReservationRepository.findByApotecary_IdAndPatient_IdAndMedicationInfo_Id(entity.getApotecary().getId(), entity.getPatient().getId(), entity.getMedicationInfo().getId()) != null){
            throw new Exception("Medication reservation with given patient, medication and apotecary already exists");
        }
        return medicationReservationRepository.save(entity);
    }

    @Override
    public MedicationReservation update(MedicationReservation entity, Long id) throws Exception {
        MedicationReservation existingMedicationReservation =  medicationReservationRepository.findById(id).orElse(null);
        if(existingMedicationReservation == null){
            throw new Exception("Medication reservation with given id doesn't exist");
        }
        existingMedicationReservation.setQuantity(entity.getQuantity());
        existingMedicationReservation.setReservationEndDate(entity.getReservationEndDate());
        existingMedicationReservation.setReservationEndTime(entity.getReservationEndTime());
        existingMedicationReservation.setStatus(entity.getStatus());

        if(medicationReservationRepository.findByApotecary_IdAndPatient_IdAndMedicationInfo_Id(entity.getApotecary().getId(), entity.getPatient().getId(), entity.getMedicationInfo().getId()) != null){
            throw new Exception("Medication reservation with given patient, medication and apotecary already exists");
        }
        return medicationReservationRepository.save(existingMedicationReservation);
    }

    @Override
    public void delete(Long id) throws Exception {
        MedicationReservation existingMedicationReservation = medicationReservationRepository.findById(id).orElse(null);
        if(existingMedicationReservation == null){
            throw new Exception("Medication reservation with given id doesn't exist");
        }
        medicationReservationRepository.delete(existingMedicationReservation);
    }
}
