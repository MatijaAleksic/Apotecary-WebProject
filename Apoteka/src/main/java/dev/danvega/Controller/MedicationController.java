package dev.danvega.Controller;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.MedicationDTO;
import dev.danvega.Mapper.DermatologistSearchMapper;
import dev.danvega.Mapper.MedicationMapper;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Medication;
import dev.danvega.Services.MedicationService;
import dev.danvega.Services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService = new MedicationService();

    private final MedicationMapper medicationMapper = new MedicationMapper();

    @PostMapping("/add-new")
    public ResponseEntity<Long> add_new_medication(@RequestBody MedicationDTO medicationDTO)
    {
        Medication med = medicationMapper.toEntity(medicationDTO);
        Medication returnMed;

        try {
            returnMed = medicationService.create(med);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(returnMed.getId(), HttpStatus.CREATED);
    }
}
