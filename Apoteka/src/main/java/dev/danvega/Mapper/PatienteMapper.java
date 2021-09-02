package dev.danvega.Mapper;

import dev.danvega.DTO.AdministratorDTO;
import dev.danvega.DTO.PatientDTO;
import dev.danvega.Model.Patient;

public class PatienteMapper implements MapperInterface<Patient, PatientDTO> {

    @Override
    public Patient toEntity(PatientDTO dto) {
        return new Patient(dto.getFirstname(),dto.getLastname(),dto.getUsername(),dto.getPassword(),dto.getEmail(),dto.getAdress(),dto.getCity(), dto.getCountry(),dto.getPhone());
    }

    @Override
    public PatientDTO toDto(Patient entity) {
        return new PatientDTO(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getUsername(), entity.getPassword(), entity.getEmail(),entity.getAdress(),entity.getCity(),entity.getCountry(),entity.getPhone());
    }
}