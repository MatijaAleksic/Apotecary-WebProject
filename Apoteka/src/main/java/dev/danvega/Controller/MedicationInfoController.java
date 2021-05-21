package dev.danvega.Controller;

import dev.danvega.DTO.MedicationDTO;
import dev.danvega.DTO.MedicationInfoDTO;
import dev.danvega.Mapper.MedicationInfoMapper;
import dev.danvega.Mapper.MedicationMapper;
import dev.danvega.Model.Apotecary;
import dev.danvega.Model.Medication;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Services.ApotecaryService;
import dev.danvega.Services.MedicationInfoService;
import dev.danvega.Services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/medication-info")
public class MedicationInfoController {

    @Autowired
    MedicationInfoService medicationInfoService = new MedicationInfoService();

    @Autowired
    MedicationService medicationService = new MedicationService();

    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();

    private final MedicationInfoMapper medicationInfoMapper = new MedicationInfoMapper();

    @PostMapping("/add-new")
    @Transactional
    public ResponseEntity<String> add_new_medication_info(@RequestBody MedicationInfoDTO medicationInfoDTO)
    {
        MedicationInfo medInfo = medicationInfoMapper.toEntity(medicationInfoDTO);

        medInfo.setMedication(medicationService.findOne(medicationInfoDTO.getMedication_id()));
        medInfo.setApotecary(apotecaryService.findOne(medicationInfoDTO.getApotecary_id()));

        try {
            medicationInfoService.create(medInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno dodavanje nove medication info!", HttpStatus.CREATED);
    }
}
