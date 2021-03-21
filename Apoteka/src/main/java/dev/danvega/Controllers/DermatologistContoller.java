package dev.danvega.Controllers;

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

}
