package dev.danvega.Services;

import dev.danvega.Model.Pharmacist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService implements ServiceInterface<Pharmacist> {

    @Override
    public List<Pharmacist> findAll() {
        return null;
    }

    @Override
    public Pharmacist findOne(Long id) {
        return null;
    }

    @Override
    public Pharmacist create(Pharmacist entity) throws Exception {
        return null;
    }

    @Override
    public Pharmacist update(Pharmacist entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
