package dev.danvega.Controller;

import dev.danvega.DTO.ChangeInformationRequest;
import dev.danvega.DTO.PatientDTO;
import dev.danvega.DTO.PhrmacistChangeInfo;
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


    ChangeInformation change = new ChangeInformation();

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody ChangeInformationRequest cir){
        Patient patient = new Patient(cir.getName(), cir.getLastName(), cir.getUsername(), cir.getAddress(), cir.getPhoneNumber());

        try{
            patient = patientService.updateInfo(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }
    /*public String change_information(@RequestBody ChangeInformationRequest cir)
    {
        change.changeInfo(cir.getName(), cir.getLastName(), cir.getUsername(), cir.getAddress(), cir.getPhoneNumber());
        return "Uspesno ste promenili informacije";
    }*/
}


