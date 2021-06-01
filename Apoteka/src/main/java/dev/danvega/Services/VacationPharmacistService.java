package dev.danvega.Services;

import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Model.VacationPharmacist;
import dev.danvega.Repository.PharmacistRepository;
import dev.danvega.Repository.VacationPharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacationPharmacistService implements ServiceInterface<VacationPharmacist> {

    @Autowired
    private VacationPharmacistRepository vacationPharmacistRepository;


    @Override
    public List<VacationPharmacist> findAll() {
        return vacationPharmacistRepository.findAll();
    }

    @Override
    public VacationPharmacist findOne(Long id) {
        return vacationPharmacistRepository.findById(id).orElse(null);
    }

    @Override
    public VacationPharmacist create(VacationPharmacist entity) throws Exception {
        System.out.println(entity.getStartDate());
        System.out.println(entity.getFinishDate());
        System.out.println(entity.getDescription());
        return vacationPharmacistRepository.save(entity);
    }

    @Override
    public VacationPharmacist update(VacationPharmacist entity, Long id) throws Exception {

        VacationPharmacist existingVacationPharmacist =  vacationPharmacistRepository.findById(id).orElse(null);
        if(existingVacationPharmacist == null){
            throw new Exception("Pharmacist vacation with given id doesn't exist");
        }
        existingVacationPharmacist.setApproved(entity.getApproved());

        return vacationPharmacistRepository.save(existingVacationPharmacist);
    }



    @Override
    public void delete(Long id) throws Exception {

    }
}
