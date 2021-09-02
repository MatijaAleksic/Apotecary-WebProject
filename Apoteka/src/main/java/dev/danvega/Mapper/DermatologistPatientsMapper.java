package dev.danvega.Mapper;

import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.DTO.PatientDTO;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Patient;

public class DermatologistPatientsMapper implements MapperInterface<Patient, PatientDTO> {

    @Override
    public Patient toEntity(PatientDTO dto) {
        return new Patient(dto.getFirstname(), dto.getLastname(), dto.getCity(),dto.getAdress(), dto.getPhone(),dto.getCountry());
    }

    @Override
    public PatientDTO toDto(Patient entity) {
        return new PatientDTO(entity.getId(),entity.getFirstname(), entity.getLastname(),entity.getUsername(),entity.getPassword(), entity.getEmail(), entity.getAdress(), entity.getCity(),entity.getCountry(), entity.getPhone());
    }
}
