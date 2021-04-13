package dev.danvega.Services;

import dev.danvega.Model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService  implements ServiceInterface<Patient>{
    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Patient findOne(Long id) {
        return null;
    }

    @Override
    public Patient create(Patient entity) throws Exception {
        return null;
    }

    @Override
    public Patient update(Patient entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
