package dev.danvega.Services;
import dev.danvega.Model.Alergies;
import dev.danvega.Model.Apotecary;
import dev.danvega.Repository.AlergiesRepository;
import dev.danvega.Repository.ApotecaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;
import java.util.List;

@Service
public class ApotecaryService implements ServiceInterface<Apotecary>{

    @Autowired
    private ApotecaryRepository apotecaryRepository;


    @Override
    public List<Apotecary> findAll() {
        return apotecaryRepository.findAll();
    }

    public Page<Apotecary> findAll(Pageable pageable) {
        return apotecaryRepository.findAll(pageable);
    }

    @Override
    public Apotecary findOne(Long id) {
        return apotecaryRepository.findById(id).orElse(null);
    }

    @Override
    public Apotecary create(Apotecary entity) throws Exception {
        if(apotecaryRepository.findByName(entity.getName()) != null){
            throw new Exception("Apotecary with given name already exists");
        }
        return apotecaryRepository.save(entity);
    }

    @Override
    public Apotecary update(Apotecary entity, Long id) throws Exception {
        Apotecary existingApotecary =  apotecaryRepository.findById(id).orElse(null);
        if(existingApotecary == null){
            throw new Exception("Apotecary with given id doesn't exist");
        }
        existingApotecary.setAdress(entity.getAdress());
        existingApotecary.setDescription(entity.getDescription());

        if(apotecaryRepository.findByName(entity.getName()) != null){
            throw new Exception("Apotecary with given name already exists");
        }
        return apotecaryRepository.save(existingApotecary);
    }

    @Override
    public void delete(Long id) throws Exception {
        Apotecary existingApotecary = apotecaryRepository.findById(id).orElse(null);
        if(existingApotecary == null){
            throw new Exception("Apotecary with given id doesn't exist");
        }
        apotecaryRepository.delete(existingApotecary);

    }

    public List<Apotecary> searchApothecary(String name, String address){

        if(!name.isEmpty()){
            if(!address.isEmpty()){
                return apotecaryRepository.findByNameAndAdress(name, address);
            } else {
                return apotecaryRepository.findByName(name);
            }
        } else {
            if(!name.isEmpty()){
                return apotecaryRepository.findByAdress(address);
            } else {
                return apotecaryRepository.findAll();
            }
        }
    }
}
