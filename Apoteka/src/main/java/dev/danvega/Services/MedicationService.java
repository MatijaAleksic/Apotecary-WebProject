package dev.danvega.Services;

import dev.danvega.Model.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService  implements ServiceInterface<Medication>{

    @Override
    public List<Medication> findAll() {
        return null;
    }

    @Override
    public Medication findOne(Long id) {
        return null;
    }

    @Override
    public Medication create(Medication entity) throws Exception {
        return null;
    }

    @Override
    public Medication update(Medication entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
