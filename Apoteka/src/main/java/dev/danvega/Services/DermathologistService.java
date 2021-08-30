package dev.danvega.Services;

import dev.danvega.Model.*;
import dev.danvega.Repository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DermathologistService implements ServiceInterface<Dermatologist> {

    @Autowired
    private DermatologistRepository dermatologistRepository;

    @Override
    public List<Dermatologist> findAll() {
        return dermatologistRepository.findAll();
    }

    public List<Dermatologist> findAllByApotecaryId(Long id) {
        return dermatologistRepository.findByApotecary_Id(id);
    }

    public Page<Dermatologist> findAll(Pageable pageable) {
        return dermatologistRepository.findAll(pageable);
    }

    @Override
    public Dermatologist findOne(Long id) {
        return dermatologistRepository.findById(id).orElse(null);
    }

    @Override
    public Dermatologist create(Dermatologist entity) throws Exception {
        if(dermatologistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Dermatologist with given email already exists");
        }
        return dermatologistRepository.save(entity);
    }

    @Override
    public Dermatologist update(Dermatologist entity, Long id) throws Exception {
        Dermatologist existingDermatologist =  dermatologistRepository.findById(id).orElse(null);
        if(existingDermatologist == null){
            throw new Exception("Dermatologist with given id doesn't exist");
        }
        existingDermatologist.setUsername(entity.getUsername());
        existingDermatologist.setPassword(entity.getPassword());
        existingDermatologist.setFirstname(entity.getFirstname());
        existingDermatologist.setLastname(entity.getLastname());
        existingDermatologist.setAdress(entity.getAdress());
        existingDermatologist.setCity(entity.getCity());
        existingDermatologist.setCountry(entity.getCountry());
        existingDermatologist.setPhone(entity.getPhone());
        existingDermatologist.setStartHours(entity.getStartHours());
        existingDermatologist.setEndHours(entity.getEndHours());


        if(dermatologistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Dermatologist with given email already exists");
        }
        return dermatologistRepository.save(existingDermatologist);
    }

    @Override
    public void delete(Long id) throws Exception {
        Dermatologist existingDermatologist = dermatologistRepository.findById(id).orElse(null);
        if(existingDermatologist == null){
            throw new Exception("Dermatologist with given id doesn't exist");
        }
        dermatologistRepository.delete(existingDermatologist);

    }

    public Dermatologist updatePassword(Dermatologist entity) throws Exception{
        Dermatologist existingDermatologist=  dermatologistRepository.findById(entity.getId()).orElse(null);
        if(existingDermatologist == null){
            throw new Exception("Dermatologist with given id doesn't exist");
        }

        existingDermatologist.setPassword(entity.getPassword());

        if(dermatologistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Dermatologist with given email already exists");
        }
        return dermatologistRepository.save(existingDermatologist);
    }

    public Dermatologist updateInfo(Dermatologist entity) throws Exception {
        System.out.println(entity.getId());
        Dermatologist existingDermatologist = dermatologistRepository.findById(entity.getId()).orElse(null);
        if(existingDermatologist == null){
            throw new Exception("Dermatologist with given id doesn't exist");
        }
        existingDermatologist.setFirstname(entity.getFirstname());
        existingDermatologist.setLastname(entity.getLastname());
        existingDermatologist.setAdress(entity.getAdress());
        existingDermatologist.setCity(entity.getCity());
        existingDermatologist.setCountry(entity.getCountry());
        existingDermatologist.setPhone(entity.getPhone());


        if(dermatologistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Dermatologist with given email already exists");
        }
        return dermatologistRepository.save(existingDermatologist);
    }

    public List<Dermatologist> searchDermatologist(String firstname, String lastname) {

        if(!firstname.isEmpty()) {
            if (!lastname.isEmpty()) {
                return dermatologistRepository.findByFirstnameAndLastname(firstname, lastname);
            } else {
                return dermatologistRepository.findByFirstname(firstname);
            }

        }else{
            if (!lastname.isEmpty()) {
                return dermatologistRepository.findByLastname(lastname);
            }else {
                return dermatologistRepository.findAll();
            }
        }
    }

    public Dermatologist first_login_update_password(String password, Long id) throws Exception {
        Dermatologist existingPatient=  dermatologistRepository.findById(id).orElse(null);
        if(existingPatient == null){
            throw new Exception("Dermatologist with given id doesn't exist");
        }
        existingPatient.setPassword(password);
        existingPatient.setFirstTimeLogin(false);
        return dermatologistRepository.save(existingPatient);
    }

}
