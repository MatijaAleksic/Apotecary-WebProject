package dev.danvega.Mapper;

import dev.danvega.DTO.ConsultationDTO;
import dev.danvega.DTO.VisitDTO;
import dev.danvega.Model.Consultation;
import dev.danvega.Model.Visit;

public class ConsultationMapper implements MapperInterface<Consultation, ConsultationDTO>{

    @Override
    public Consultation toEntity(ConsultationDTO dto) {

        return new Consultation(dto.getId(),dto.getStartDate(),dto.getStartTime(),dto.getDuration(),dto.getPrice(),dto.getStatus(),dto.getReport());
    }

    @Override
    public ConsultationDTO toDto(Consultation entity) {
        return new ConsultationDTO(entity.getId(),entity.getStartDate(),entity.getStartTime(),entity.getDuration(),entity.getPrice(),entity.getStatus().getValue(), entity.getReport(), entity.getPharmacist().getId(), entity.getPatient().getId(), entity.getApotecary().getId());
    }
}

