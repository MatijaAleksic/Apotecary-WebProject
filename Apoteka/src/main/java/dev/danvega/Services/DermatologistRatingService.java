package dev.danvega.Services;

import dev.danvega.Model.ApotecaryRating;
import dev.danvega.Model.DermatologistRating;
import dev.danvega.Repository.ApotecaryRatingRepository;
import dev.danvega.Repository.DermatologistRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DermatologistRatingService implements ServiceInterface<DermatologistRating>{

    @Autowired
    private DermatologistRatingRepository dermatologistRatingRepository;

    @Override
    public List<DermatologistRating> findAll() {
        return dermatologistRatingRepository.findAll();
    }

    public Page<DermatologistRating> findAll(Pageable pageable) {
        return dermatologistRatingRepository.findAll(pageable);
    }

    @Override
    public DermatologistRating findOne(Long id) {
        return dermatologistRatingRepository.findById(id).orElse(null);
    }

    @Override
    public DermatologistRating create(DermatologistRating entity) throws Exception {
        if(dermatologistRatingRepository.findByDermatologist_IdAndPatient_Id(entity.getDermatologist().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Dermatologist rating with given patient and given apotecary already exists");
        }
        return dermatologistRatingRepository.save(entity);
    }

    @Override
    public DermatologistRating update(DermatologistRating entity, Long id) throws Exception {
        DermatologistRating existingDermatologistRating =  dermatologistRatingRepository.findById(id).orElse(null);
        if(existingDermatologistRating == null){
            throw new Exception("Dermatologist rating rating with given id doesn't exist");
        }
        existingDermatologistRating.setRating(entity.getRating());

        if(dermatologistRatingRepository.findByDermatologist_IdAndPatient_Id(entity.getDermatologist().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Dermatologist rating with given patient and given apotecary already exists");
        }
        return dermatologistRatingRepository.save(existingDermatologistRating);
    }

    @Override
    public void delete(Long id) throws Exception {
        DermatologistRating existingDermatologistRating = dermatologistRatingRepository.findById(id).orElse(null);
        if(existingDermatologistRating == null){
            throw new Exception("Dermatologist rating with given id doesn't exist");
        }
        dermatologistRatingRepository.delete(existingDermatologistRating);

    }
}
