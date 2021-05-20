package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.DTO.PatientDTO;
import dev.danvega.Model.Medication;
import dev.danvega.Model.Patient;

public class MedicationMapper implements MapperInterface<Medication, MedicationDTO>{
    @Override
    public Medication toEntity(MedicationDTO dto) {
        return new Medication(dto.getName(),dto.getMedicationType());
    }

    @Override
    public MedicationDTO toDto(Medication entity) {
        return new MedicationDTO(entity.getName(), entity.getMedicationType());
    }
}
