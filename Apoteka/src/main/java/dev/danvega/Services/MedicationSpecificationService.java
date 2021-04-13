package dev.danvega.Services;

import dev.danvega.Model.MedicationSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationSpecificationService  implements ServiceInterface<MedicationSpecification>{

    @Override
    public List<MedicationSpecification> findAll() {
        return null;
    }

    @Override
    public MedicationSpecification findOne(Long id) {
        return null;
    }

    @Override
    public MedicationSpecification create(MedicationSpecification entity) throws Exception {
        return null;
    }

    @Override
    public MedicationSpecification update(MedicationSpecification entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
