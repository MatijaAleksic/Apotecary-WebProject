package dev.danvega.Mapper;

import dev.danvega.DTO.VisitDTO;
import dev.danvega.DTO.VisitTableDTO;
import dev.danvega.Model.Visit;

public class VisitTableMapper implements MapperInterface<Visit, VisitTableDTO>{
    @Override
    public Visit toEntity(VisitTableDTO dto) {
        return new Visit(dto.getId(),dto.getStartDate(),dto.getStartTime(),dto.getDuration(),dto.getPrice(),dto.getStatus(),dto.getReport());
    }

    @Override
    public VisitTableDTO toDto(Visit entity) {

        if (entity.getPatient() == null) {
            return new VisitTableDTO(entity.getId(), entity.getStartDate(), entity.getStartTime(), entity.getDuration(), entity.getPrice(), entity.getStatus().getValue(), entity.getReport(), "", "");

        }
        else {
            return new VisitTableDTO(entity.getId(), entity.getStartDate(), entity.getStartTime(), entity.getDuration(), entity.getPrice(), entity.getStatus().getValue(), entity.getReport(), entity.getPatient().getFirstname(), entity.getPatient().getLastname(),entity.getPatient().getId());
        }
        }

}
