package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.DTO.MedicationReservationDTO;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationReservation;

public class MedicationReservationMapper implements MapperInterface<MedicationReservation, MedicationReservationDTO>{
    @Override
    public MedicationReservation toEntity(MedicationReservationDTO dto) {
        return new MedicationReservation(dto.getId(),dto.getEndDate(),dto.getEndTime(), dto.getQuantity(), dto.getStatus());
    }

    @Override
    public MedicationReservationDTO toDto(MedicationReservation entity) {
        if(entity.getConsultation() == null && entity.getVisit() == null)
        {
            return new MedicationReservationDTO(entity.getId(),entity.getReservationEndDate(),entity.getReservationEndTime(),entity.getQuantity(),null, null,entity.getPatient().getFirstname(),entity.getPatient().getLastname());
        }
        else if(entity.getConsultation() == null )
        {
            return new MedicationReservationDTO(entity.getId(),entity.getReservationEndDate(),entity.getReservationEndTime(),entity.getQuantity(),null, entity.getVisit().getId(),entity.getPatient().getFirstname(),entity.getPatient().getLastname());
        }

        else if(entity.getVisit() == null)
        {
            return new MedicationReservationDTO(entity.getId(),entity.getReservationEndDate(),entity.getReservationEndTime(),entity.getQuantity(),entity.getConsultation().getId(), null,entity.getPatient().getFirstname(),entity.getPatient().getLastname());

        }
        return new MedicationReservationDTO(entity.getId(),entity.getReservationEndDate(),entity.getReservationEndTime(),entity.getQuantity(),entity.getConsultation().getId(), entity.getVisit().getId(),entity.getPatient().getFirstname(),entity.getPatient().getLastname());
    }
}
