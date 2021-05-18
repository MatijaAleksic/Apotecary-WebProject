package dev.danvega.Controller;

import dev.danvega.DTO.*;
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


    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody PatientChangeInfoDTO ci){
        Patient patient = new Patient(ci.getId(), ci.getFirstName(), ci.getLastName(), ci.getUsername(), ci.getAddress(), ci.getPhoneNumber());

        try{
            patient = patientService.updateInfo(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Success! You just changed your information.", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        System.out.println(cpr.getId());
        Patient patient = new Patient(cpr.getId(), cpr.getNewPassword());
        try{
            System.out.println(patient.getId());
            patient = patientService.updatePassword(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Success! You just changed your password.", HttpStatus.OK);
    }
    /*public String change_information(@RequestBody ChangeInformationRequest cir)
    {
        change.changeInfo(cir.getName(), cir.getLastName(), cir.getUsername(), cir.getAddress(), cir.getPhoneNumber());
        return "Uspesno ste promenili informacije";
    }*/
}


