package dev.danvega.Services;

import dev.danvega.Model.DermatologistRating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DermatologistRatingService implements ServiceInterface<DermatologistRating>{

    @Override
    public List<DermatologistRating> findAll() {
        return null;
    }

    @Override
    public DermatologistRating findOne(Long id) {
        return null;
    }

    @Override
    public DermatologistRating create(DermatologistRating entity) throws Exception {
        return null;
    }

    @Override
    public DermatologistRating update(DermatologistRating entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
