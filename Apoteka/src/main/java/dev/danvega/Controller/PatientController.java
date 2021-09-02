package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.AdministratorMapper;
import dev.danvega.Mapper.PatienteMapper;
import dev.danvega.Model.Administrator;
import dev.danvega.Model.Patient;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Services.ChangeInformation;
import dev.danvega.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")


public class PatientController {

    @Autowired
    PatientService patientService = new PatientService();

    PatienteMapper patientMapper = new PatienteMapper();


    ChangeInformation change = new ChangeInformation();

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody AdminChangeInfo cir){
        System.out.println(cir.getId());
        Patient patient = new Patient(cir.getId(), cir.getFirstname(), cir.getLastname(), cir.getAddress(),
                cir.getCity(),cir.getCountry(), cir.getPhone());
        try{
            patientService.updateInfo(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        Patient patient = new Patient(cpr.getId(), cpr.getNewPassword());
        try{
            patientService.updatePassword(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
    }

    @PostMapping("/get-personal-info")
    public ResponseEntity<PatientDTO> get_personal_info(@RequestBody UserIDDTO userIDDTO)
    {
        Patient patient;
        try {
            patient = patientService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patientMapper.toDto(patient), HttpStatus.OK);
    }

}


