package dev.danvega.Services;
import dev.danvega.Model.Alergies;
import dev.danvega.Model.Consultation;
import dev.danvega.Model.Patient;
import dev.danvega.Model.Visit;
import dev.danvega.Repository.AlergiesRepository;
import dev.danvega.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService implements ServiceInterface<Consultation>{

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    public Page<Consultation> findAll(Pageable pageable) {
        return consultationRepository.findAll(pageable);
    }

    @Override
    public Consultation findOne(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation create(Consultation entity) throws Exception {

        return consultationRepository.save(entity);
    }

    @Override
    public Consultation update(Consultation entity, Long id) throws Exception {
        Consultation existingConsultation =  consultationRepository.findById(id).orElse(null);
        if(existingConsultation == null){
            throw new Exception("Consultation with given id doesn't exist");
        }
        existingConsultation.setDuration(entity.getDuration());
        existingConsultation.setPrice(entity.getPrice());
        existingConsultation.setReport(entity.getReport());
        existingConsultation.setStartDate(entity.getStartDate());
        existingConsultation.setStartTime(entity.getStartTime());
        existingConsultation.setStatus(entity.getStatus());

        if(consultationRepository.findByApotecary_IdAndPatient_IdAndPharmacist_Id(entity.getApotecary().getId(),entity.getPatient().getId(),entity.getPharmacist().getId()) != null){
            throw new Exception("Consultation for given patient, pharmacist, apotecary already exists");
        }
        return consultationRepository.save(existingConsultation);
    }

    @Override
    public void delete(Long id) throws Exception {

        Consultation existingConsultation = consultationRepository.findById(id).orElse(null);
        if(existingConsultation == null){
            throw new Exception("Consultation with given id doesn't exist");
        }
        consultationRepository.delete(existingConsultation);
    }

    public List<Patient> viewPatients(Long id) {
        List<Consultation> counsultations = consultationRepository.findByPharmacist_Id(id);
        ArrayList<Patient> patients = new ArrayList<Patient>();
        for(Consultation x : counsultations){
            patients.add(x.getPatient());
        }
        return patients;
    }
}
