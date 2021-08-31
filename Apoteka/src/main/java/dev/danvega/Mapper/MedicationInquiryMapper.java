package dev.danvega.Mapper;

import dev.danvega.DTO.MedicationInfoDTO;
import dev.danvega.DTO.MedicationInquiryDTO;
import dev.danvega.Model.Apotecary;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Model.MedicationInquiry;

public class MedicationInquiryMapper implements MapperInterface<MedicationInquiry, MedicationInquiryDTO>{

    public MedicationInquiry toEntity(MedicationInquiryDTO dto, Medication med, Apotecary apo) {
        return new MedicationInquiry(dto.getQuantity(),apo,med);
    }

    @Override
    public MedicationInquiry toEntity(MedicationInquiryDTO dto) {
        return new MedicationInquiry(dto.getQuantity());
    }

    @Override
    public MedicationInquiryDTO toDto(MedicationInquiry entity) {
        return new MedicationInquiryDTO(entity.getId(), entity.getMedication().getId(), entity.getApotecary().getId(), entity.getQuantity(), entity.getMedication().getName());
    }
}
