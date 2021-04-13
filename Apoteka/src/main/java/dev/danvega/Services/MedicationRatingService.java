package dev.danvega.Services;

import dev.danvega.Model.MedicationRating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationRatingService  implements ServiceInterface<MedicationRating>{

    @Override
    public List<MedicationRating> findAll() {
        return null;
    }

    @Override
    public MedicationRating findOne(Long id) {
        return null;
    }

    @Override
    public MedicationRating create(MedicationRating entity) throws Exception {
        return null;
    }

    @Override
    public MedicationRating update(MedicationRating entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
