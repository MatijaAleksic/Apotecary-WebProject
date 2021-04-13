package dev.danvega.Services;

import dev.danvega.Model.Administrator;
import dev.danvega.Repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class AdministratorService implements ServiceInterface<Administrator>{


    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public List<Administrator> findAll() {
        return administratorRepository.findAll();
    }

    public Page<Administrator> findAll(Pageable pageable) {
        return administratorRepository.findAll(pageable);
    }

    @Override
    public Administrator findOne(Long id) {
        return administratorRepository.findById(id).orElse(null);
    }

    @Override
    public Administrator create(Administrator entity) throws Exception {
        if(administratorRepository.findByEmail(entity.getEmail()) != null){
            throw new Exception("Administrator with given email already exists");
        }
        return administratorRepository.save(entity);
    }

    @Override
    public Administrator update(Administrator entity, Long id) throws Exception {
        Administrator existingAdministrator =  administratorRepository.findById(id).orElse(null);
        if(existingAdministrator == null){
            throw new Exception("Administrator with given id doesn't exist");
        }
        existingAdministrator.setUsername(entity.getUsername());
        existingAdministrator.setPassword(entity.getPassword());
        existingAdministrator.setFirstname(entity.getFirstname());
        existingAdministrator.setLastname(entity.getLastname());
        existingAdministrator.setAdress(entity.getAdress());
        existingAdministrator.setCity(entity.getCity());
        existingAdministrator.setCountry(entity.getCountry());
        existingAdministrator.setPhone(entity.getPhone());

        if(administratorRepository.findByUsername(existingAdministrator.getUsername()) != null){
            throw new Exception("Administrator with given username already exists");
        }
        return administratorRepository.save(existingAdministrator);
    }

    @Override
    public void delete(Long id) throws Exception {
        Administrator existingAdministrator = administratorRepository.findById(id).orElse(null);
        if(existingAdministrator == null){
            throw new Exception("Administrator with given id doesn't exist");
        }
        administratorRepository.delete(existingAdministrator);
    }
}
