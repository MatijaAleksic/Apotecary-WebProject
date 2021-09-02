package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationListDTO;
import dev.danvega.Model.Medication;

public class MedicationListMapper implements MapperInterface<Medication, MedicationListDTO>{
    @Override
    public Medication toEntity(MedicationListDTO dto) {
        return new Medication(dto.getId(), dto.getName());
    }

    @Override
    public MedicationListDTO toDto(Medication entity) {
        return new MedicationListDTO(entity.getId(), entity.getName());
    }
}
