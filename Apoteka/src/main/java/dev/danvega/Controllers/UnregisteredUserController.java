package dev.danvega.Controllers;

import Model.Pacijent;
import Services.ChangeInformation;
import Services.DermathologistService;
import Services.Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unregistered")


public class UnregisteredUserController {

    Login login = new Login();

    @PostMapping("/login")
    public String change_information(@RequestBody LoginRequest lr)
    {
        Pacijent p = new Pacijent("Uros","Stojanovic", "uros.stojanovic99@gmail.com", "ustojanovic", "12345", "njegoseva 14", "12864918246");

        if(lr.username.equalsIgnoreCase(p.getUsername()) && lr.password.equalsIgnoreCase(p.getPassword())){
            return "Uspesno ulogovan " + p.getUsername();
        }
        else {
            return "Username ili sifra se ne poklapaju.";

        }

    }
}


