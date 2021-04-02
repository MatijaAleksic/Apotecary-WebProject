package dev.danvega.Mapper;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.Model.Dermatologist;

public class DermatologistSearchMapper implements MapperInterface<Dermatologist, DermatologistSearchDTO>{

    @Override
    public Dermatologist toEntity(DermatologistSearchDTO dto) {
        return new Dermatologist(dto.getFirstname(), dto.getLastname(), dto.getApotecary());
    }

    @Override
    public DermatologistSearchDTO toDto(Dermatologist entity) {
        return new DermatologistSearchDTO(entity.getFirstname(), entity.getFirstname(),entity.getApotecary(), entity.getRatings());
    }
}
