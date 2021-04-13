package dev.danvega.Services;

import dev.danvega.Model.Dermatologist;
import dev.danvega.Repository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DermathologistService implements ServiceInterface<Dermatologist> {

    @Autowired
    private DermatologistRepository dermatologistRepository;

    public DermathologistService() {}

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

    @Override
    public List<Dermatologist> findAll() {
        return null;
    }

    @Override
    public Dermatologist findOne(Long id) {
        return null;
    }

    public Dermatologist create(Dermatologist entity) throws Exception {
        if(dermatologistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Dermatologist with given name already exists");
        }
        return dermatologistRepository.save(entity);
    }

    @Override
    public Dermatologist update(Dermatologist entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
