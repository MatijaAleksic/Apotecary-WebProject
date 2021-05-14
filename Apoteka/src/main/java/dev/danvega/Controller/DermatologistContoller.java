package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Mapper.DermatologistPatientsMapper;
import dev.danvega.Mapper.DermatologistSearchMapper;
import dev.danvega.Model.Administrator;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Patient;
import dev.danvega.Model.Visit;
import dev.danvega.Services.ApotecaryService;
import dev.danvega.Services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.danvega.Services.DermathologistService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dermatologist")
public class DermatologistContoller {

    @Autowired
    DermathologistService dermathologistService = new DermathologistService();

    @Autowired
    VisitService visitService = new VisitService();

    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();

    private final DermatologistSearchMapper dermatologistSearchMapper = new DermatologistSearchMapper();
    private final DermatologistMapper dermatologistMapper = new DermatologistMapper();
    private final DermatologistPatientsMapper dermatologistPatientsMapper = new DermatologistPatientsMapper();

    @RequestMapping(value="search/name={firstname}&lastname={lastname}", method=RequestMethod.GET)
    public ResponseEntity<List<DermatologistSearchDTO>> searchDermatologist(@PathVariable String firstname, @PathVariable String lastname){
        List<Dermatologist> dermatologists = dermathologistService.searchDermatologist(firstname,lastname);
        if(dermatologists == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toDermatologistSearchDTOList(dermatologists));
    }

    @PostMapping("/view-patitents")
    public ResponseEntity<List<PatientDTO>> view_patients(@RequestBody Long id)
    {
        List<Patient> patients = visitService.viewPatients(id);
        if(patients == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toPatientDTOList(patients));
    }

    @PostMapping("/register-new")
    public ResponseEntity<String> register_dermatologist(@RequestBody DermatologistDTO dermatologistDTO)
    {
        Dermatologist derma = dermatologistMapper.toEntity(dermatologistDTO);
        derma.setApotecary(apotecaryService.findOne(dermatologistDTO.getApotecary_id()));
        derma.setFirstTimeLogin(true);

        try {
            dermathologistService.create(derma);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno registrovan dermatolog!", HttpStatus.CREATED);
    }

    private List<DermatologistDTO> toDermatologistDTOList(List<Dermatologist> dermatologists){
        List<DermatologistDTO> dermatologistDTOS = new ArrayList<>();
        for (Dermatologist dermatologist : dermatologists) {
            dermatologistDTOS.add(dermatologistMapper.toDto(dermatologist));
        }
        return dermatologistDTOS;
    }

    private List<DermatologistSearchDTO> toDermatologistSearchDTOList(List<Dermatologist> dermatologists){
        List<DermatologistSearchDTO> dermatologistDTOS = new ArrayList<>();
        for (Dermatologist dermatologist : dermatologists) {
            dermatologistDTOS.add(dermatologistSearchMapper.toDto(dermatologist));
        }
        return dermatologistDTOS;
    }

    private List<PatientDTO> toPatientDTOList(List<Patient> patients){
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(dermatologistPatientsMapper.toDto(patient));
        }
        return patientDTOS;
    }
}
