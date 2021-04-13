package dev.danvega.Services;

import dev.danvega.Model.ApotecaryRating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApotecaryRatingService implements ServiceInterface<ApotecaryRating>{


    @Override
    public List<ApotecaryRating> findAll() {
        return null;
    }

    @Override
    public ApotecaryRating findOne(Long id) {
        return null;
    }

    @Override
    public ApotecaryRating create(ApotecaryRating entity) throws Exception {
        return null;
    }

    @Override
    public ApotecaryRating update(ApotecaryRating entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
