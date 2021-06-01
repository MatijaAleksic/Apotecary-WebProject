package dev.danvega.Services;

import dev.danvega.Model.VacationDermatologist;
import dev.danvega.Model.VacationPharmacist;
import dev.danvega.Repository.VacationDermatologistRepository;
import dev.danvega.Repository.VacationPharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationDermatologistService implements ServiceInterface<VacationDermatologist>{

    @Autowired
    private VacationDermatologistRepository vacationDermatologistRepository;


    @Override
    public List<VacationDermatologist> findAll() {
        return vacationDermatologistRepository.findAll();
    }

    @Override
    public VacationDermatologist findOne(Long id) {
        return vacationDermatologistRepository.findById(id).orElse(null);
    }

    @Override
    public VacationDermatologist create(VacationDermatologist entity) throws Exception {
        return vacationDermatologistRepository.save(entity);
    }

    @Override
    public VacationDermatologist update(VacationDermatologist entity, Long id) throws Exception {
        VacationDermatologist existingVacationDermatologist =  vacationDermatologistRepository.findById(id).orElse(null);
        if(existingVacationDermatologist == null){
            throw new Exception("Dermatologist vacation with given id doesn't exist");
        }
        existingVacationDermatologist.setApproved(entity.getApproved());

        return vacationDermatologistRepository.save(existingVacationDermatologist);
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
