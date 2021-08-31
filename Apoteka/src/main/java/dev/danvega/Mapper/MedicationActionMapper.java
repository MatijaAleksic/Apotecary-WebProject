package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationActionDTO;
import dev.danvega.DTO.MedicationInquiryDTO;
import dev.danvega.Model.*;

public class MedicationActionMapper implements MapperInterface<MedicationAction, MedicationActionDTO> {

    public MedicationAction toEntity(MedicationActionDTO dto, MedicationInfo medInfo) {
        return new MedicationAction(dto.getActionStartDate(), dto.getActionStartTime(), dto.getActionEndDate(),dto.getActionEndTime(), medInfo, dto.getProcentage());
    }

    @Override
    public MedicationAction toEntity(MedicationActionDTO dto) {
        return new MedicationAction();
    }

    @Override
    public MedicationActionDTO toDto(MedicationAction entity) {
        return new MedicationActionDTO(entity.getId(), entity.getActionStartDate(), entity.getActionStartTime(), entity.getActionEndDate(), entity.getActionEndTime(), entity.getMedicationInfo().getId(), entity.getProcentage());
    }
}


