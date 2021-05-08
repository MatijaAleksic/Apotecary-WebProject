package dev.danvega.Controller;

import dev.danvega.DTO.AdminChangeInfo;
import dev.danvega.DTO.ChangePasswordRequest;
import dev.danvega.Model.Administrator;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Services.AdministratorService;
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
        System.out.println(cpr.getId());
        Administrator admin = new Administrator(cpr.getId(), cpr.getNewPassword());
        System.out.println(cpr.getId());
        try{
            administratorService.updatePassword(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
    }
}
