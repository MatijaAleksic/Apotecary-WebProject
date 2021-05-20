package dev.danvega.Mapper;


import dev.danvega.DTO.MedicationDTO;
import dev.danvega.Model.Medication;

public class MedicationMapper implements MapperInterface<Medication, MedicationDTO>{

    @Override
    public Medication toEntity(MedicationDTO dto){
        return new Medication(dto.getId(), dto.getName(), dto.getSpecification());
    }

    @Override
    public MedicationDTO toDto(Medication entity){
        return new MedicationDTO(entity.getId(), entity.getName(), entity.getSpecification());
    }
}
