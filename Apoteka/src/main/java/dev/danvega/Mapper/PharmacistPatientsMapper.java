package dev.danvega.Mapper;

import dev.danvega.DTO.PatientDTO;
import dev.danvega.Model.Patient;

public class PharmacistPatientsMapper implements MapperInterface<Patient, PatientDTO> {
    @Override
    public Patient toEntity(PatientDTO dto) {
        return new Patient(dto.getName(), dto.getLastName(), dto.getCity(),dto.getAddress(), dto.getPhone()
                ,dto.getCountry());
    }

    @Override
    public PatientDTO toDto(Patient entity) {
        return new PatientDTO(entity.getFirstname(), entity.getLastname(), entity.getCity(), entity.getAdress(), entity.getPhone(),
                entity.getCountry());
    }
}
