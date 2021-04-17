package dev.danvega.Controller;

import dev.danvega.DTO.ChangePasswordRequest;
import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.DTO.PatientDTO;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Mapper.DermatologistPatientsMapper;
import dev.danvega.Mapper.DermatologistSearchMapper;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Patient;
import dev.danvega.Model.Visit;
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
    VisitService visitService = new VisitService();
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
    public ResponseEntity<DermatologistDTO> register_dermathologist(@RequestBody DermatologistDTO dermatologistDTO)
    {
        Dermatologist dermatologist;
        try {
            dermatologist = dermathologistService.create(dermatologistMapper.toEntity(dermatologistDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dermatologistMapper.toDto(dermatologist), HttpStatus.CREATED);
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody ChangePasswordRequest cpr){
        Dermatologist derm = new Dermatologist("Pera","Peric", "peki","123456", "");
        System.out.print("Jhaafasf");
        if(cpr.getOldPassword().equalsIgnoreCase(derm.getPassword())){
            derm.setPassword(cpr.getNewPassword());
            return "Uspesno promenjena sifra";
        }
        else{
            return "Nije promenjena sifra";
        }
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
