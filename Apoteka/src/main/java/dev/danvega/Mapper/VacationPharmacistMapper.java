package dev.danvega.Mapper;

import dev.danvega.DTO.PhrmacistChangeInfo;
import dev.danvega.DTO.VacationPharmacistDTO;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Model.VacationPharmacist;

public class VacationPharmacistMapper implements MapperInterface<VacationPharmacist, VacationPharmacistDTO>{
    @Override
    public VacationPharmacist toEntity(VacationPharmacistDTO dto) {
        return new VacationPharmacist(dto.getId(),dto.getStartDate(),dto.getFinishDate(),dto.getDescription(),dto.getPharmacist_id(),
                dto.getApprodved());
    }

    public static VacationPharmacist toEntityDTO(VacationPharmacistDTO dto) {
        return new VacationPharmacist(dto.getId(),dto.getStartDate(),dto.getFinishDate(),dto.getDescription(),dto.getPharmacist_id(),
                dto.getApprodved());
    }

    @Override
    public VacationPharmacistDTO toDto(VacationPharmacist entity) {
        return new VacationPharmacistDTO(entity.getId(), entity.getStartDate(),entity.getFinishDate(),entity.getDescription(),entity.getPharmacist().getId(),
                entity.isApproved());
    }
}
