package dev.danvega.Services;

import dev.danvega.Model.VacationDermatologist;
import dev.danvega.Repository.VacationDermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacationDermatologistService implements ServiceInterface<VacationDermatologist>{

    @Autowired
    VacationDermatologistRepository vacationDermatologistRepository;

    @Override
    public List<VacationDermatologist> findAll() {
        return vacationDermatologistRepository.findAll();
    }

    @Override
    public VacationDermatologist findOne(Long id) {
        return vacationDermatologistRepository.findById(id).orElse(null);
    }

    @Override
    public VacationDermatologist create(VacationDermatologist entity) throws Exception {
        return vacationDermatologistRepository.save(entity);
    }

    @Override
    public VacationDermatologist update(VacationDermatologist entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
