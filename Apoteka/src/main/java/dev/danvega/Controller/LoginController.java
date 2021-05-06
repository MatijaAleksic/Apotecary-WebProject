package dev.danvega.Controller;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.DTO.LoginDTO;
import dev.danvega.Model.*;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unsigned")
public class LoginController {
//    @Autowired
//    DermathologistService dermathologistService = new DermathologistService();
//
//    @Autowired
//    PharmacistService pharmacistService = new PharmacistService();
//
//    @Autowired
//    AdministratorService administratorService = new AdministratorService();
//
//    @Autowired
//    PatientService patientService = new PatientService();

    @Autowired
    UserService userService = new UserService();


    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws Exception {
        User user = null;
        String ret = "";
        try {
            user = userService.findUser(loginDTO.getUsername(), loginDTO.getPassword());
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(user.getClass() == Patient.class){

            ret = "patient";
        }
        else if(user.getClass() == Administrator.class){

            ret = "administrator";
        }
        if(user.getClass() == Pharmacist.class){

            ret = "pharmacist";
        }if(user.getClass() == Dermatologist.class){

            ret = "dermatoligist";
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);

    }

}
