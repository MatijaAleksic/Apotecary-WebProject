package dev.danvega.Controller;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.DTO.MedicationSpecificationDTO;
import dev.danvega.Mapper.MedicationInfoMapper;
import dev.danvega.Mapper.MedicationSpecificationMapper;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationSpecification;
import dev.danvega.Services.ApotecaryService;
import dev.danvega.Services.MedicationService;
import dev.danvega.Services.MedicationSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/medication-specifications")
public class MedicationSpecificationController {

    @Autowired
    MedicationSpecificationService medicationSpecificationService = new MedicationSpecificationService();

    @Autowired
    MedicationService medicationService = new MedicationService();

    private final MedicationSpecificationMapper medicationSpecificationMapper = new MedicationSpecificationMapper();


    @PostMapping("/add-new")
    @Transactional
    public ResponseEntity<String> add_new_medication_specification(@RequestBody MedicationSpecificationDTO medicationSpecificationDTO)
    {
        MedicationSpecification medSpec = medicationSpecificationMapper.toEntity(medicationSpecificationDTO);
        medSpec.setMedication(medicationService.findOne(medicationSpecificationDTO.getMedication_id()));

        try {
            medicationSpecificationService.create(medSpec);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno dodavanje novog leka!", HttpStatus.CREATED);
    }

}
