package dev.danvega.Controller;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.Mapper.MedicationMapper;
import dev.danvega.Model.Medication;
import dev.danvega.Services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService = new MedicationService();

    private final MedicationMapper medicationMapper = new MedicationMapper();

    @GetMapping(value="/list")
    public ResponseEntity<List<MedicationDTO>> listMedication(){
        List<Medication> medication = medicationService.findAll();
        if (medication == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toMedicationDTOList(medication));
    }

    private List<MedicationDTO> toMedicationDTOList(List<Medication> medication){
        List<MedicationDTO> medicationDTOS = new ArrayList<>();
        for (Medication med : medication){
            medicationDTOS.add(medicationMapper.toDto(med));
        }
        return medicationDTOS;
    }
}
