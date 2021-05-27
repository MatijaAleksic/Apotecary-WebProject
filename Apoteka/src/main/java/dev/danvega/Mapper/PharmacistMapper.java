package dev.danvega.Mapper;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.PharmacistDTO;
import dev.danvega.DTO.PhrmacistChangeInfo;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Pharmacist;

import java.sql.Time;

public class PharmacistMapper implements MapperInterface<Pharmacist, PhrmacistChangeInfo> {

    @Override
    public Pharmacist toEntity(PhrmacistChangeInfo dto) {
        return new Pharmacist(dto.getName(), dto.getLastName(), dto.getCity(),dto.getAddress(), dto.getPhone()
                ,dto.getCountry());
    }

    public Pharmacist toEntityDTO(PharmacistDTO dto) {

        return new Pharmacist(dto.getFirstname(), dto.getLastname(), dto.getUsername(), dto.getPassword(), dto.getEmail(),dto.getAdress(), dto.getCity(),dto.getCountry(),dto.getPhone(), Time.valueOf(dto.getStartHours()), Time.valueOf(dto.getEndHours()));

    }

    @Override
    public PhrmacistChangeInfo toDto(Pharmacist entity) {
        return new PhrmacistChangeInfo(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getUsername(), entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone());
    }

    public PharmacistDTO toDTO(Pharmacist entity) {
        return new PharmacistDTO(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getUsername(),entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone(), entity.getApotecary().getId(),entity.getStartHours(), entity.getEndHours());
    }
}
