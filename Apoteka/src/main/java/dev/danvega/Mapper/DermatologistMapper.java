package dev.danvega.Mapper;


import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.Model.Dermatologist;

public class DermatologistMapper implements MapperInterface<Dermatologist, DermatologistDTO> {

    @Override
    public Dermatologist toEntity(DermatologistDTO dto) {
        return new Dermatologist(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getPassword(), dto.getEmail(),dto.getAdress(), dto.getCity(),dto.getCountry(),dto.getPhone());
    }

    @Override
    public DermatologistDTO toDto(Dermatologist entity) {
        return new DermatologistDTO(entity.getFirstname(), entity.getLastname(), entity.getUsername(), entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone());
    }
}
