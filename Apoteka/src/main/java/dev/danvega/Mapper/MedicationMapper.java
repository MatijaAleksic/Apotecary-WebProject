package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.Model.Enums.MedicationType;
import dev.danvega.Model.Medication;

public class MedicationMapper implements MapperInterface<Medication, MedicationDTO>{
    @Override
    public Medication toEntity(MedicationDTO dto) {
        return new Medication(dto.getName(), MedicationType.fromInteger(dto.getMedicationType()));
    }

    @Override
    public MedicationDTO toDto(Medication entity) {
        return new MedicationDTO(entity.getName(), entity.getMedicationType().getValue());
    }
}
