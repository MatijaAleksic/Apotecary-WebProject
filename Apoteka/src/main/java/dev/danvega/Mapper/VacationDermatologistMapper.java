package dev.danvega.Mapper;

import dev.danvega.DTO.VacationDermatologistDTO;
import dev.danvega.DTO.VacationPharmacistDTO;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Model.VacationDermatologist;
import dev.danvega.Model.VacationPharmacist;

public class VacationDermatologistMapper implements MapperInterface<VacationDermatologist, VacationDermatologistDTO>{

    @Override
    public VacationDermatologist toEntity(VacationDermatologistDTO dto) {
        return new VacationDermatologist(dto.getId(),dto.getStartDate(),dto.getFinishDate(),dto.getDescription(),dto.getDermatologist_id(),
                StatusCV.valueOf(dto.getApprodved()));
    }

    public static VacationDermatologist toEntityDTO(VacationDermatologistDTO dto) {
        return new VacationDermatologist(dto.getId(),dto.getStartDate(),dto.getFinishDate(),dto.getDescription(),dto.getDermatologist_id(),
                StatusCV.valueOf(dto.getApprodved()));
    }


    @Override
    public VacationDermatologistDTO toDto(VacationDermatologist entity) {
        return new VacationDermatologistDTO(entity.getId(), entity.getStartDate(),entity.getFinishDate(),entity.getDescription(),entity.getDermatologist().getId(),
                entity.getApproved().toString());
    }
}

