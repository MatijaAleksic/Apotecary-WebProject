package dev.danvega.Controllers;

import Services.ChangeInformation;
import Services.DermathologistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")


public class PatientController {

    ChangeInformation change = new ChangeInformation();

    @PostMapping("/change-information")
    public String change_information(@RequestBody ChangeInformationRequest cir)
    {
        change.changeInfo(cir.name, cir.lastName, cir.username, cir.address, cir.phoneNumber);
        return "Uspesno promenjeno ime iz Uros u " + cir.name + "\n Uspesno promenjeno prezime iz Stojanovic u " + cir.lastName
                + "\n Uspesno promenjen username iz ustojanovic u " + cir.username + "\n Uspesno promenjena adresa iz njegoseva 14 u "
                + cir.address + "\n Uspesno promenjen broj telefona iz 12864918246 u " + cir.phoneNumber;
    }
}


