package dev.danvega.Services;

import dev.danvega.Model.MedicationReservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationReservationService implements ServiceInterface<MedicationReservation> {

    @Override
    public List<MedicationReservation> findAll() {
        return null;
    }

    @Override
    public MedicationReservation findOne(Long id) {
        return null;
    }

    @Override
    public MedicationReservation create(MedicationReservation entity) throws Exception {
        return null;
    }

    @Override
    public MedicationReservation update(MedicationReservation entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
