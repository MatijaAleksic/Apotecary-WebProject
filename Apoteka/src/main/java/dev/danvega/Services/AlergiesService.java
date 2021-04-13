package dev.danvega.Services;

import dev.danvega.Model.Administrator;
import dev.danvega.Model.Alergies;
import dev.danvega.Repository.AdministratorRepository;
import dev.danvega.Repository.AlergiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiesService implements ServiceInterface<Alergies>{

    @Autowired
    private AlergiesRepository alergiesRepository;

    @Override
    public List<Alergies> findAll() {
        return alergiesRepository.findAll();
    }

    public Page<Alergies> findAll(Pageable pageable) {
        return alergiesRepository.findAll(pageable);
    }

    @Override
    public Alergies findOne(Long id) {
        return alergiesRepository.findById(id).orElse(null);
    }

    @Override
    public Alergies create(Alergies entity) throws Exception {
//        if(alergiesRepository.findByEmail(entity.getEmail()) != null){
//            throw new Exception("Administrator with given name already exists");
//        }
//        return administratorRepository.save(entity);
        return null;
    }

    @Override
    public Alergies update(Alergies entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
