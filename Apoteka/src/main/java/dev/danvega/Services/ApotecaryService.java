package dev.danvega.Services;
import dev.danvega.Model.Apotecary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApotecaryService implements ServiceInterface<Apotecary>{
    @Override
    public List<Apotecary> findAll() {
        return null;
    }

    @Override
    public Apotecary findOne(Long id) {
        return null;
    }

    @Override
    public Apotecary create(Apotecary entity) throws Exception {
        return null;
    }

    @Override
    public Apotecary update(Apotecary entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
