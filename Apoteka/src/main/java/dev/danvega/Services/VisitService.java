package dev.danvega.Services;
import dev.danvega.Model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService implements ServiceInterface<Visit>{

    @Override
    public List<Visit> findAll() {
        return null;
    }

    @Override
    public Visit findOne(Long id) {
        return null;
    }

    @Override
    public Visit create(Visit entity) throws Exception {
        return null;
    }

    @Override
    public Visit update(Visit entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
