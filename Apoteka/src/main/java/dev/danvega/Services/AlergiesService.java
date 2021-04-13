package dev.danvega.Services;

import dev.danvega.Model.Alergies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiesService implements ServiceInterface<Alergies>{
    @Override
    public List<Alergies> findAll() {
        return null;
    }

    @Override
    public Alergies findOne(Long id) {
        return null;
    }

    @Override
    public Alergies create(Alergies entity) throws Exception {
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
