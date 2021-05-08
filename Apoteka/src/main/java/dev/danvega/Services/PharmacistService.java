package dev.danvega.Services;


import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Repository.DermatologistRepository;
import dev.danvega.Repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService implements ServiceInterface<Pharmacist> {

    @Autowired
    private PharmacistRepository pharmacistRepository;


    @Override
    public List<Pharmacist> findAll() {
        return pharmacistRepository.findAll();
    }

    public Page<Pharmacist> findAll(Pageable pageable) {
        return pharmacistRepository.findAll(pageable);
    }

    @Override
    public Pharmacist findOne(Long id) {
        return pharmacistRepository.findById(id).orElse(null);
    }

    @Override
    public Pharmacist create(Pharmacist entity) throws Exception {
        if(pharmacistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Pharmacist with given email already exists");
        }
        return pharmacistRepository.save(entity);
    }

    @Override
    public Pharmacist update(Pharmacist entity, Long id) throws Exception {
        Pharmacist existingPharmacist=  pharmacistRepository.findById(id).orElse(null);
        if(existingPharmacist == null){
            throw new Exception("Pharmacist with given id doesn't exist");
        }
        existingPharmacist.setUsername(entity.getUsername());
        existingPharmacist.setPassword(entity.getPassword());
        existingPharmacist.setFirstname(entity.getFirstname());
        existingPharmacist.setLastname(entity.getLastname());
        existingPharmacist.setAdress(entity.getAdress());
        existingPharmacist.setCity(entity.getCity());
        existingPharmacist.setCountry(entity.getCountry());
        existingPharmacist.setPhone(entity.getPhone());
        existingPharmacist.setStartHours(entity.getStartHours());
        existingPharmacist.setEndHours(entity.getEndHours());

        if(pharmacistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Pharmacist with given email already exists");
        }
        return pharmacistRepository.save(existingPharmacist);    }

    public Pharmacist updatePassword(Pharmacist entity) throws Exception{
        Pharmacist existingPharmacist=  pharmacistRepository.findById(entity.getId()).orElse(null);
        if(existingPharmacist == null){
            throw new Exception("Pharmacist with given id doesn't exist");
        }

        existingPharmacist.setPassword(entity.getPassword());

        if(pharmacistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Pharmacist with given email already exists");
        }
        return pharmacistRepository.save(existingPharmacist);
    }

    public Pharmacist updateInfo(Pharmacist entity) throws Exception {
        Pharmacist existingPharmacist=  pharmacistRepository.findById(entity.getId()).orElse(null);
        if(existingPharmacist == null){
            throw new Exception("Pharmacist with given id doesn't exist");
        }
        existingPharmacist.setFirstname(entity.getFirstname());
        existingPharmacist.setLastname(entity.getLastname());
        existingPharmacist.setAdress(entity.getAdress());
        existingPharmacist.setCity(entity.getCity());
        existingPharmacist.setCountry(entity.getCountry());
        existingPharmacist.setPhone(entity.getPhone());


        if(pharmacistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Pharmacist with given email already exists");
        }
        return pharmacistRepository.save(existingPharmacist);
    }

    @Override
    public void delete(Long id) throws Exception {
        Pharmacist existingPharmacist= pharmacistRepository.findById(id).orElse(null);
        if(existingPharmacist == null){
            throw new Exception("Pharmacist with given id doesn't exist");
        }
        pharmacistRepository.delete(existingPharmacist);
    }
}
