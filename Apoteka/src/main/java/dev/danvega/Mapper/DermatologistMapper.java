package dev.danvega.Mapper;


import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.Model.Dermatologist;

public class DermatologistMapper implements MapperInterface<Dermatologist, DermatologistDTO> {

    @Override
    public Dermatologist toEntity(DermatologistDTO dto) {
        return new Dermatologist(dto.getFirstname(), dto.getLastname(), dto.getApotecary(),dto.getRatings());
    }

    @Override
    public DermatologistDTO toDto(Dermatologist entity) {
        return new DermatologistDTO(entity.getFirstname(), entity.getFirstname(),entity.getApotecary(), entity.getRatings());
    }
}
