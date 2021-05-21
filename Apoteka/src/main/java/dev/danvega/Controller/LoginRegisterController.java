package dev.danvega.Controller;

import dev.danvega.DTO.*;
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

    @Autowired
    PharmacistService pharmacistService = new PharmacistService();

    @Autowired
    DermathologistService dermathologistService = new DermathologistService();

    @Autowired
    AdministratorService administratorService = new AdministratorService();

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) throws Exception {
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

        LoginResponseDTO response = new LoginResponseDTO(ret,Boolean.toString(user.getFirstTimeLogin()),user.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);

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


    @PostMapping(path = "/first-login")
    public ResponseEntity<String> firstLogin(@RequestBody FirstLoginChangePasswordDTO firstLoginChangePasswordDTO) throws Exception {
        try {
            User user;
            user = patientService.findOne(firstLoginChangePasswordDTO.getUserId());
            if(user == null)
            {
                user = administratorService.findOne(firstLoginChangePasswordDTO.getUserId());
            }
            if(user == null)
            {
                user = dermathologistService.findOne(firstLoginChangePasswordDTO.getUserId());
            }
            if(user == null)
            {
                user = pharmacistService.findOne(firstLoginChangePasswordDTO.getUserId());
            }


            if(user != null) {
                if (user.getClass() == Patient.class) {
                    patientService.first_login_update_password(firstLoginChangePasswordDTO.getNewPassword(), firstLoginChangePasswordDTO.getUserId());
                } else if (user.getClass() == Administrator.class) {
                    administratorService.first_login_update_password(firstLoginChangePasswordDTO.getNewPassword(), firstLoginChangePasswordDTO.getUserId());
                }
                if (user.getClass() == Pharmacist.class) {
                    pharmacistService.first_login_update_password(firstLoginChangePasswordDTO.getNewPassword(), firstLoginChangePasswordDTO.getUserId());
                }
                if (user.getClass() == Dermatologist.class) {
                    dermathologistService.first_login_update_password(firstLoginChangePasswordDTO.getNewPassword(), firstLoginChangePasswordDTO.getUserId());
                }
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Uspesna izmenjena sifra!", HttpStatus.OK);
    }

}
