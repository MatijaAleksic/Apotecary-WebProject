package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationInfoDTO;
import dev.danvega.DTO.MedicationSpecificationDTO;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Model.MedicationSpecification;

public class MedicationSpecificationMapper implements MapperInterface<MedicationSpecification, MedicationSpecificationDTO> {

    @Override
    public MedicationSpecification toEntity(MedicationSpecificationDTO dto) {
        return new MedicationSpecification(dto.getContradictions(),dto.getComposition(), dto.getDailyIntake(),dto.getReplacementDrugs());
    }

    @Override
    public MedicationSpecificationDTO toDto(MedicationSpecification entity) {
        return new MedicationSpecificationDTO(entity.getContradictions(),entity.getComposition(),entity.getDailyIntake(),entity.getReplacementDrugs(),entity.getMedication().getId());
    }

    public MedicationSpecification toEntity(MedicationSpecificationDTO dto, Medication med) {
        return new MedicationSpecification(dto.getContradictions(),dto.getComposition(), dto.getDailyIntake(),dto.getReplacementDrugs(),med);
    }
}
