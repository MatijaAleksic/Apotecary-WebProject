package dev.danvega.Services;

import dev.danvega.Model.Dermatologist;
import dev.danvega.Repository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DermathologistService {

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

    public Dermatologist create(Dermatologist entity) throws Exception {
        if(dermatologistRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Dermatologist with given name already exists");
        }
        return dermatologistRepository.save(entity);
    }
}
