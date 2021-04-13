package dev.danvega.Services;

import dev.danvega.Model.MedicationInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationInfoService  implements ServiceInterface<MedicationInfo> {

    @Override
    public List<MedicationInfo> findAll() {
        return null;
    }

    @Override
    public MedicationInfo findOne(Long id) {
        return null;
    }

    @Override
    public MedicationInfo create(MedicationInfo entity) throws Exception {
        return null;
    }

    @Override
    public MedicationInfo update(MedicationInfo entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
