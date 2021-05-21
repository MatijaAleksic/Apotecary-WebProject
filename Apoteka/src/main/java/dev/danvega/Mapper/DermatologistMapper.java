package dev.danvega.Mapper;


import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.Model.Dermatologist;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class DermatologistMapper implements MapperInterface<Dermatologist, DermatologistDTO> {

    @Override
    public Dermatologist toEntity(DermatologistDTO dto) {

        return new Dermatologist(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getPassword(), dto.getEmail(),dto.getAdress(), dto.getCity(),dto.getCountry(),dto.getPhone(), Time.valueOf(dto.getStartHours()), Time.valueOf(dto.getEndHours()));
    }

    @Override
    public DermatologistDTO toDto(Dermatologist entity) {
        return new DermatologistDTO(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getUsername(), entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone(),entity.getApotecary().getId(),entity.getStartHours().toLocalTime(),entity.getEndHours().toLocalTime());
    }
}
