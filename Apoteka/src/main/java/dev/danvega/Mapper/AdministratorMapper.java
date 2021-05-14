package dev.danvega.Mapper;

import dev.danvega.DTO.AdministratorDTO;
import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.Model.Administrator;
import dev.danvega.Model.Dermatologist;

public class AdministratorMapper implements MapperInterface<Administrator, AdministratorDTO> {

    @Override
    public Administrator toEntity(AdministratorDTO dto) {
        return new Administrator(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getPassword(), dto.getEmail(),dto.getAdress(), dto.getCity(),dto.getCountry(),dto.getPhone(), dto.getApotecary_id());
    }

    @Override
    public AdministratorDTO toDto(Administrator entity) {
        return new AdministratorDTO(entity.getFirstname(), entity.getLastname(), entity.getUsername(), entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone(), entity.getApotecary().getId());
    }
}
