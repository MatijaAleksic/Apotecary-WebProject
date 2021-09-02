package dev.danvega.Services;

import dev.danvega.Model.Alergies;
import dev.danvega.Repository.AlergiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiesService implements ServiceInterface<Alergies>{

    @Autowired
    private AlergiesRepository alergiesRepository;

    @Override
    public List<Alergies> findAll() {
        return alergiesRepository.findAll();
    }

    public Page<Alergies> findAll(Pageable pageable) {
        return alergiesRepository.findAll(pageable);
    }

    public List<Alergies> findALlByPatient_Id(Long patientID)
    {
        return alergiesRepository.findByPatient_Id(patientID);
    }

    @Override
    public Alergies findOne(Long id) {
        return alergiesRepository.findById(id).orElse(null);
    }

    @Override
    public Alergies create(Alergies entity) throws Exception {
        if(alergiesRepository.findByPatient_IdAndMedication_Id(entity.getPatient().getId(), entity.getMedication().getId()) != null){
            throw new Exception("Alergie for this patient and this medication already exists");
        }
        return alergiesRepository.save(entity);
    }

    @Override
    public Alergies update(Alergies entity, Long id) throws Exception {
        Alergies existingAlergie =  alergiesRepository.findById(id).orElse(null);
        if(existingAlergie == null){
            throw new Exception("Alergie with given id doesn't exist");
        }
        existingAlergie.setMedication(entity.getMedication());
        existingAlergie.setPatient(entity.getPatient());

        if(alergiesRepository.findByPatient_IdAndMedication_Id(entity.getPatient().getId(), entity.getMedication().getId()) != null){
            throw new Exception("Alergie for this patient and this medication already exists");
        }
        return alergiesRepository.save(existingAlergie);
    }

    @Override
    public void delete(Long id) throws Exception {
        Alergies existingAlergie = alergiesRepository.findById(id).orElse(null);
        if(existingAlergie == null){
            throw new Exception("Alergie with given id doesn't exist");
        }
        alergiesRepository.delete(existingAlergie);

    }
}
