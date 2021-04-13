package dev.danvega.Services;

import dev.danvega.Model.DermatologistRating;
import dev.danvega.Model.PharmacistRating;
import dev.danvega.Repository.DermatologistRatingRepository;
import dev.danvega.Repository.PharmacistRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistRatingService implements ServiceInterface<PharmacistRating> {

    @Autowired
    private PharmacistRatingRepository pharmacistRatingRepository;


    @Override
    public List<PharmacistRating> findAll() {
        return pharmacistRatingRepository.findAll();
    }

    public Page<PharmacistRating> findAll(Pageable pageable) {
        return pharmacistRatingRepository.findAll(pageable);
    }

    @Override
    public PharmacistRating findOne(Long id) {
        return pharmacistRatingRepository.findById(id).orElse(null);
    }

    @Override
    public PharmacistRating create(PharmacistRating entity) throws Exception {
        if(pharmacistRatingRepository.findByPharmacist_IdAndPatient_Id(entity.getPharmacist().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Pharmacist rating with given patient and given pharmacist already exists");
        }
        return pharmacistRatingRepository.save(entity);
    }

    @Override
    public PharmacistRating update(PharmacistRating entity, Long id) throws Exception {
        PharmacistRating existingPharmacistRating =  pharmacistRatingRepository.findById(id).orElse(null);
        if(existingPharmacistRating == null){
            throw new Exception("Pharmacist rating rating with given id doesn't exist");
        }
        existingPharmacistRating.setRating(entity.getRating());

        if(pharmacistRatingRepository.findByPharmacist_IdAndPatient_Id(entity.getPharmacist().getId(), entity.getPatient().getId()) != null){
            throw new Exception("Pharmacist rating with given patient and given pharmacist already exists");
        }
        return pharmacistRatingRepository.save(existingPharmacistRating);
    }

    @Override
    public void delete(Long id) throws Exception {
        PharmacistRating existingPharmacistRating = pharmacistRatingRepository.findById(id).orElse(null);
        if(existingPharmacistRating == null){
            throw new Exception("Pharmacist rating with given id doesn't exist");
        }
        pharmacistRatingRepository.delete(existingPharmacistRating);

    }
}
