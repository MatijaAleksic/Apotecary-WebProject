package dev.danvega.Services;

import dev.danvega.Model.PharmacistRating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistRatingService implements ServiceInterface<PharmacistRating> {

    @Override
    public List<PharmacistRating> findAll() {
        return null;
    }

    @Override
    public PharmacistRating findOne(Long id) {
        return null;
    }

    @Override
    public PharmacistRating create(PharmacistRating entity) throws Exception {
        return null;
    }

    @Override
    public PharmacistRating update(PharmacistRating entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
