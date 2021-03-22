package dev.danvega.Controllers;

import Model.Dermatologist;
import org.springframework.web.bind.annotation.*;
import Services.DermathologistService;

@RestController
@RequestMapping("/api/dermatologist")
public class DermatologistContoller {

    DermathologistService dermathologistService = new DermathologistService();

    @PostMapping("/register-new")
    public String register_dermathologist(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
                                          @RequestParam("username") String username,@RequestParam("password") String password)
    {
        dermathologistService.registerDermathologist(firstName,lastName,username,password);
        return "Uspesno registrovan dermatolog!";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody ChangePasswordRequest cpr){
        Dermatologist derm = new Dermatologist("Pera","Peric", "peki","123456");
        System.out.print("Jhaafasf");
        if(cpr.oldPassword.equalsIgnoreCase(derm.getPassword())){
            derm.setPassword(cpr.newPassword);
            return "Uspesno promenjena sifra";
        }
        else{
            return "Nije promenjena sifra";
        }
    }
}
