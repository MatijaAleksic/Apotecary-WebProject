package dev.danvega.Controllers;

import Model.Dermatologist;
import Model.Pharmacist;
import Services.DermathologistService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacist")
public class PharmacistController {

    @PostMapping("/changePasswordPharmacist")
    public String changePasswordPharmacist(@RequestBody ChangePasswordRequest cpr){
        Pharmacist phrm = new Pharmacist("Sima","Simic", "smiki","123456");
        if(cpr.oldPassword.equalsIgnoreCase(phrm.getPassword())){
            phrm.setPassword(cpr.newPassword);
            return "Uspesno promenjena sifra";
        }
        else{
            return "Nije promenjena sifra";
        }
    }
}
