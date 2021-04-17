package dev.danvega.Controller;

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
    public ResponseEntity<PhrmacistChangeInfo> changeInformation(@RequestBody PhrmacistChangeInfo pci){
        Pharmacist pharmacist;
        try{
            pharmacist = pharmacistService.updateInfo(pharmacistMapper.toEntity(pci));
        } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
        return new ResponseEntity<String>(pharmacistMapper.toDto(pharmacist), HttpStatus.OK);
    }
}
