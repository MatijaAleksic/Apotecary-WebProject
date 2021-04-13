package dev.danvega.Controller;

import dev.danvega.DTO.ChangeInformationRequest;
import dev.danvega.Services.ChangeInformation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")


public class PatientController {

    ChangeInformation change = new ChangeInformation();

    @PostMapping("/change-information")
    public String change_information(@RequestBody ChangeInformationRequest cir)
    {
        change.changeInfo(cir.getName(), cir.getLastName(), cir.getUsername(), cir.getAddress(), cir.getPhoneNumber());
        return "Uspesno promenjeno ime iz Uros u " + cir.getName() + "\n Uspesno promenjeno prezime iz Stojanovic u " + cir.getLastName()
                + "\n Uspesno promenjen username iz ustojanovic u " + cir.getUsername() + "\n Uspesno promenjena adresa iz njegoseva 14 u "
                + cir.getAddress() + "\n Uspesno promenjen broj telefona iz 12864918246 u " + cir.getPhoneNumber();
    }
}


