package dev.danvega.Services;
import dev.danvega.Model.Consultation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService implements ServiceInterface<Consultation>{

    @Override
    public List<Consultation> findAll() {
        return null;
    }

    @Override
    public Consultation findOne(Long id) {
        return null;
    }

    @Override
    public Consultation create(Consultation entity) throws Exception {
        return null;
    }

    @Override
    public Consultation update(Consultation entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
