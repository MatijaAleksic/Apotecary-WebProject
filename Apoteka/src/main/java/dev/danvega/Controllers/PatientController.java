package dev.danvega.Controllers;

import Services.ChangeInformation;
import Services.DermathologistService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")


public class PatientController {

    ChangeInformation change = new ChangeInformation();

    @PostMapping("/change-information")
    public String change_information(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                                          @RequestParam("username") String username,
                                     @RequestParam("address") String address, @RequestParam("phoneNumber") String phoneNumber)
    {
        change.changeInfo(name,lastName,username, address, phoneNumber);
        return "Uspesno promenjeno ime iz Uros u " + name + "\n Uspesno promenjeno prezime iz Stojanovic u " + lastName
                + "\n Uspesno promenjen username iz ustojanovic u " + username + "\n Uspesno promenjena adresa iz njegoseva 14 u "
                + address + "\n Uspesno promenjen broj telefona iz 12864918246 u " + phoneNumber;
    }
}


