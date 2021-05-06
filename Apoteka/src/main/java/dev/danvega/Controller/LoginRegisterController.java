package dev.danvega.Controller;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.DTO.LoginDTO;
import dev.danvega.DTO.RegisterPatientDTO;
import dev.danvega.Model.*;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unsigned")
public class LoginRegisterController {
    @Autowired
    UserService userService = new UserService();

    @Autowired
    PatientService patientService = new PatientService();

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws Exception {
        User user = null;
        String ret = "";
        try {
            user = userService.findUser(loginDTO.getUsername(), loginDTO.getPassword());
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(user.getClass() == Patient.class){
            ret = "patient";
        }else if(user.getClass() == Administrator.class){
            ret = "administrator";
        }if(user.getClass() == Pharmacist.class){
            ret = "pharmacist";
        }if(user.getClass() == Dermatologist.class){
            ret = "dermatoligist";
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);

    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody RegisterPatientDTO registerPatientDTO) throws Exception {
        Patient patient = new Patient(registerPatientDTO.getFirstname(), registerPatientDTO.getLastname(), registerPatientDTO.getUsername(), registerPatientDTO.getPassword(),
                registerPatientDTO.getEmail(), registerPatientDTO.getAdress(), registerPatientDTO.getCity(), registerPatientDTO.getCountry(), registerPatientDTO.getPhone());
        try {
            patientService.create(patient);
        }catch(Exception e){
            return new ResponseEntity<>("Nevalidni kredencijali pokusajte opet!",HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>("Uspesna registracija!", HttpStatus.OK);

    }

}
