package dev.danvega.Mapper;

import dev.danvega.DTO.VisitDTO;
import dev.danvega.Model.Visit;


public class VisitMapper implements MapperInterface<Visit, VisitDTO>{

    @Override
    public Visit toEntity(VisitDTO dto) {

        return new Visit(dto.getId(),dto.getStartDate(),dto.getStartTime(),dto.getDuration(),dto.getPrice(),dto.getStatus(),dto.getReport());
    }

    @Override
    public VisitDTO toDto(Visit entity) {
        return new VisitDTO(entity.getId(),entity.getStartDate(),entity.getStartTime(),entity.getDuration(),entity.getPrice(),entity.getStatus().getValue(), entity.getReport(), entity.getDermatologist().getId(), entity.getPatient().getId(), entity.getApotecary().getId());
    }

}

