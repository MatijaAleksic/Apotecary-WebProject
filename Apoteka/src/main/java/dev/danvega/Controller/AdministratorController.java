package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.AdministratorMapper;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Model.Administrator;
import dev.danvega.Model.Apotecary;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Services.AdministratorService;
import dev.danvega.Services.ApotecaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService = new AdministratorService();

    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();

    AdministratorMapper administratorMapper = new AdministratorMapper();

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody AdminChangeInfo adminDTO){

        Administrator admin = new Administrator(adminDTO.getId(), adminDTO.getFirstname(), adminDTO.getLastname(), adminDTO.getAddress(),
                adminDTO.getCity(),adminDTO.getCountry(), adminDTO.getPhone());

        try{
            administratorService.update_info(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        Administrator admin = new Administrator(cpr.getId(), cpr.getNewPassword());
        try{
            administratorService.updatePassword(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
    }

    @PostMapping("/register-new")
    public ResponseEntity<String> register_administrator(@RequestBody AdministratorDTO administratorDTO)
    {

        Administrator admin = administratorMapper.toEntity(administratorDTO);

        Apotecary temp = apotecaryService.findOne(administratorDTO.getApotecary_id());
        if(temp==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        admin.setFirstTimeLogin(true);

        try {
            administratorService.create(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno registrovan administrator!", HttpStatus.CREATED);
    }

    @PostMapping("/search_apotecary")
    public ResponseEntity<String> search_apotecary(@RequestBody AdministratorDTO administratorDTO)
    {
        Apotecary a;
        try {
            a = apotecaryService.findOne(administratorDTO.getApotecary_id());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String b = "neuspjesno!";
        if(a.getId() == 1L)
        {
            b = "uspjesno!";
        }
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @PostMapping("/get-apotecary-id")
    public ResponseEntity<Long> get_apotecary(@RequestBody UserIDDTO userIDDTO)
    {
        Administrator admin;
        try {
            admin = administratorService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(admin.getApotecary().getId(), HttpStatus.OK);
    }

    @PostMapping("/get-personal-info")
    public ResponseEntity<AdministratorDTO> get_personal_info(@RequestBody UserIDDTO userIDDTO)
    {
        Administrator admin;
        try {
            admin = administratorService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(administratorMapper.toDto(admin), HttpStatus.OK);
    }
}
