package dev.danvega.Services;

import dev.danvega.Model.Administrator;
import dev.danvega.Model.Patient;
import dev.danvega.Repository.AdministratorRepository;
import dev.danvega.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService  implements ServiceInterface<Patient>{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Page<Patient> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Patient findOne(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient create(Patient entity) throws Exception {
        if(patientRepository.findByUsernameAndEmail(entity.getUsername(), entity.getEmail()) != null){
            throw new Exception("Patient with given credentials already exists");
        }
        return patientRepository.save(entity);
    }

    @Override
    public Patient update(Patient entity, Long id) throws Exception {
        Patient existingPatient=  patientRepository.findById(id).orElse(null);
        if(existingPatient == null){
            throw new Exception("Administrator with given id doesn't exist");
        }
        existingPatient.setUsername(entity.getUsername());
        existingPatient.setPassword(entity.getPassword());
        existingPatient.setFirstname(entity.getFirstname());
        existingPatient.setLastname(entity.getLastname());
        existingPatient.setAdress(entity.getAdress());
        existingPatient.setCity(entity.getCity());
        existingPatient.setCountry(entity.getCountry());
        existingPatient.setPhone(entity.getPhone());

        if(patientRepository.findByUsername(existingPatient.getUsername()) != null){
            throw new Exception("Patient with given username already exists");
        }
        return patientRepository.save(existingPatient);
    }



    @Override
    public void delete(Long id) throws Exception {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if(existingPatient == null){
            throw new Exception("Patient with given id doesn't exist");
        }
        patientRepository.delete(existingPatient);

    }

    public Patient first_login_update_password(String password, Long id) throws Exception {
        Patient existingPatient=  patientRepository.findById(id).orElse(null);
        if(existingPatient == null){
            throw new Exception("Patient with given id doesn't exist");
        }
        existingPatient.setPassword(password);
        existingPatient.setFirstTimeLogin(false);
        return patientRepository.save(existingPatient);
    }
}
