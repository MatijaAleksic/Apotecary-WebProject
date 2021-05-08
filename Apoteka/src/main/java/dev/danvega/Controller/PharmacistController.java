package dev.danvega.Controller;

import dev.danvega.DTO.ChangePasswordRequest;
import dev.danvega.DTO.PhrmacistChangeInfo;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Mapper.PharmacistMapper;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Services.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacist")
public class PharmacistController {

    @Autowired
    PharmacistService pharmacistService = new PharmacistService();
    private final PharmacistMapper pharmacistMapper = new PharmacistMapper();


    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody PhrmacistChangeInfo pci){
        Pharmacist pharmacist = new Pharmacist(pci.getId(), pci.getName(), pci.getLastName(), pci.getCity(),pci.getAddress(), pci.getPhone(), pci.getCountry());

        try{
            pharmacist = pharmacistService.updateInfo(pharmacist);
        } catch (Exception e) {
            e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        System.out.println(cpr.getId());
        Pharmacist pharmacist = new Pharmacist(cpr.getId(), cpr.getNewPassword());
        try{
            System.out.println(pharmacist.getId());
            pharmacist = pharmacistService.updatePassword(pharmacist);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
    }

}
