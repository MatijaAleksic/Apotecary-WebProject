package dev.danvega.Controller;

import dev.danvega.DTO.LoginDTO;
import dev.danvega.Model.Patient;
import dev.danvega.Services.ChangeInformation;
import dev.danvega.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")


public class PatientController {

    ChangeInformation change = new ChangeInformation();
    @Autowired
    PatientService patientService = new PatientService();

    @PostMapping("/change-information")
    public String change_information(@RequestBody ChangeInformationRequest cir)
    {
        change.changeInfo(cir.name, cir.lastName, cir.username, cir.address, cir.phoneNumber);
        return "Uspesno promenjeno ime iz Uros u " + cir.name + "\n Uspesno promenjeno prezime iz Stojanovic u " + cir.lastName
                + "\n Uspesno promenjen username iz ustojanovic u " + cir.username + "\n Uspesno promenjena adresa iz njegoseva 14 u "
                + cir.address + "\n Uspesno promenjen broj telefona iz 12864918246 u " + cir.phoneNumber;
    }

    @PostMapping(value="login/username={username}&password={password}")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO)
    {
        if(patientService.exists(loginDTO.getUsername(), loginDTO.getPassword())){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}


