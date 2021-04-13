package dev.danvega.Services;

import dev.danvega.Model.Administrator;
import dev.danvega.Model.Alergies;
import dev.danvega.Model.ApotecaryRating;
import dev.danvega.Repository.ApotecaryRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApotecaryRatingService implements ServiceInterface<ApotecaryRating>{

    @Autowired
    private ApotecaryRatingRepository apotecaryRatingRepository;

    @Override
    public List<ApotecaryRating> findAll() {
        return apotecaryRatingRepository.findAll();
    }

    public Page<ApotecaryRating> findAll(Pageable pageable) {
        return apotecaryRatingRepository.findAll(pageable);
    }

    @Override
    public ApotecaryRating findOne(Long id) {
        return apotecaryRatingRepository.findById(id).orElse(null);
    }

    @Override
    public ApotecaryRating create(ApotecaryRating entity) throws Exception {
        if(apotecaryRatingRepository.findByApotecary_IdAndPatient_Id(entity.getApotecary().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Apotecary rating with given patient and given apotecary already exists");
        }
        return apotecaryRatingRepository.save(entity);
    }

    @Override
    public ApotecaryRating update(ApotecaryRating entity, Long id) throws Exception {
        ApotecaryRating existingApotecaryRating =  apotecaryRatingRepository.findById(id).orElse(null);
        if(existingApotecaryRating == null){
            throw new Exception("Alergie rating with given id doesn't exist");
        }
        existingApotecaryRating.setRating(entity.getRating());

        if(apotecaryRatingRepository.findByApotecary_IdAndPatient_Id(entity.getApotecary().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Apotecary rating with given patient and given apotecary already exists");
        }
        return apotecaryRatingRepository.save(existingApotecaryRating);
    }

    @Override
    public void delete(Long id) throws Exception {
        ApotecaryRating existingApotecaryRating = apotecaryRatingRepository.findById(id).orElse(null);
        if(existingApotecaryRating == null){
            throw new Exception("Alergie rating with given id doesn't exist");
        }
        apotecaryRatingRepository.delete(existingApotecaryRating);
    }
}
