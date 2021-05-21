package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.DTO.MedicationInfoDTO;
import dev.danvega.Model.Apotecary;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationInfo;

public class MedicationInfoMapper  implements MapperInterface<MedicationInfo, MedicationInfoDTO>{


    public MedicationInfo toEntity(MedicationInfoDTO dto, Medication med, Apotecary apo) {
        return new MedicationInfo(dto.getPrice(), dto.getPriceDurationEndDate(), dto.getPriceDurationEndTime(), dto.getInStorage(),
                apo,med);
    }

    @Override
    public MedicationInfo toEntity(MedicationInfoDTO dto) {
        return new MedicationInfo(dto.getPrice(), dto.getPriceDurationEndDate(), dto.getPriceDurationEndTime(), dto.getInStorage());
    }

    @Override
    public MedicationInfoDTO toDto(MedicationInfo entity) {
        return new MedicationInfoDTO(entity.getPrice(), entity.getPriceDurationEndDate(), entity.getPriceDurationEndTime(),entity.getInStorage(),
                entity.getMedication().getId(), entity.getApotecary().getId());
    }

}
