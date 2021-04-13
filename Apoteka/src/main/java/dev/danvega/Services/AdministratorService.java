package dev.danvega.Services;

import dev.danvega.Model.Administrator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService implements ServiceInterface<Administrator>{


    @Override
    public List<Administrator> findAll() {
        return null;
    }

    @Override
    public Administrator findOne(Long id) {
        return null;
    }

    @Override
    public Administrator create(Administrator entity) throws Exception {
        return null;
    }

    @Override
    public Administrator update(Administrator entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
