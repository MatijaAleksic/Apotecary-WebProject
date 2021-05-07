package dev.danvega.Mapper;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.PhrmacistChangeInfo;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Pharmacist;

public class PharmacistMapper implements MapperInterface<Pharmacist, PhrmacistChangeInfo> {

    @Override
    public Pharmacist toEntity(PhrmacistChangeInfo dto) {
        return new Pharmacist(dto.getName(), dto.getLastName(), dto.getCity(),dto.getAddress(), dto.getPhone()
                ,dto.getCountry());
    }

    @Override
    public PhrmacistChangeInfo toDto(Pharmacist entity) {
        return new PhrmacistChangeInfo(entity.getFirstname(), entity.getLastname(), entity.getUsername(), entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone());
    }
}
