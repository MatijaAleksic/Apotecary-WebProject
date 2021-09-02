package dev.danvega.Services;
import dev.danvega.Model.Consultation;
import dev.danvega.Model.Patient;
import dev.danvega.Model.Visit;
import dev.danvega.Repository.ConsultationRepository;
import dev.danvega.Repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VisitService implements ServiceInterface<Visit>{

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public List<Visit> findByApotecary_Id(Long apotecary_id) { return visitRepository.findByApotecary_Id(apotecary_id);}

    public List<Visit> findByApotecary_IdAnd_Dermatologist_Id(Long apotecary_id, Long dermatologist_id)
    {
        return visitRepository.findByApotecary_IdAndDermatologist_Id(apotecary_id,dermatologist_id);
    }

    public List<Visit> findByPatient_Id(Long patient_id){
        return visitRepository.findByPatient_Id(patient_id);
    }

    public Page<Visit> findAll(Pageable pageable) {
        return visitRepository.findAll(pageable);
    }

    @Override
    public Visit findOne(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit create(Visit entity) throws Exception {
        return visitRepository.save(entity);
    }

    @Override
    public Visit update(Visit entity, Long id) throws Exception {
        Visit existingVisit =  visitRepository.findById(id).orElse(null);
        if(existingVisit == null){
            throw new Exception("Visit with given id doesn't exist");
        }
        existingVisit.setDuration(entity.getDuration());
        existingVisit.setPrice(entity.getPrice());
        existingVisit.setReport(entity.getReport());
        existingVisit.setStartDate(entity.getStartDate());
        existingVisit.setStartTime(entity.getStartTime());
        existingVisit.setStatus(entity.getStatus());
        existingVisit.setPatient(entity.getPatient());

        return visitRepository.save(existingVisit);
    }

    @Override
    public void delete(Long id) throws Exception {
        Visit existingVisit = visitRepository.findById(id).orElse(null);
        if(existingVisit == null){
            throw new Exception("Visit with given id doesn't exist");
        }
        if(existingVisit.getPatient() != null)
        {
            throw new Exception("Visit with given id has patient for it and thus cannot be deleted");
        }
        visitRepository.delete(existingVisit);
    }

    public List<Patient> viewPatients(Long id) {
        List<Visit> visits = visitRepository.findByDermatologist_Id(id);
        ArrayList<Patient> patients = new ArrayList<Patient>();
        for(Visit x : visits){
            if(x.getPatient() != null) {
                patients.add(x.getPatient());
            }
        }
        return patients;
    }
}
