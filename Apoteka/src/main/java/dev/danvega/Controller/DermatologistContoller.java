package dev.danvega.Controller;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Model.Dermatologist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.danvega.Services.DermathologistService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dermatologist")
public class DermatologistContoller {

    @Autowired
    DermathologistService dermathologistService = new DermathologistService();
    private final DermatologistMapper dermatologistMapper = new DermatologistMapper();

    @RequestMapping(value="/name={firstname}?lastname={lastname}", method=RequestMethod.GET)
    public ResponseEntity<DermatologistDTO> searchDermatologist(@PathVariable String firstname, @PathVariable String lastname){
        List<Dermatologist> dermatologists = dermathologistService.searchDermatologist(firstname,lastname);

        if(dermatologists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);

        //return ResponseEntity.ok(toDermatologistDTOList(dermatologists));
    }

    @PostMapping("/register-new")
    public String register_dermathologist(@RequestBody RegisterDermatologistRequest rdr)
    {
        if(dermathologistService.registerDermathologist(rdr.getName(), rdr.getLastName(), rdr.getUsername(), rdr.getPassword())) {
            return "Uspesno registrovan dermatolog!";
        }
        else{
            return "Vec postoji!";
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody ChangePasswordRequest cpr){
        Dermatologist derm = new Dermatologist("Pera","Peric", "peki","123456", "");
        System.out.print("Jhaafasf");
        if(cpr.oldPassword.equalsIgnoreCase(derm.getPassword())){
            derm.setPassword(cpr.newPassword);
            return "Uspesno promenjena sifra";
        }
        else{
            return "Nije promenjena sifra";
        }
    }

    private List<DermatologistDTO> toDermatologistDTOList(List<Dermatologist> dermatologists){
        List<DermatologistDTO> dermatologistDTOS = new ArrayList<>();
        for (Dermatologist dermatologist : dermatologists) {
            dermatologistDTOS.add(dermatologistMapper.toDto(dermatologist));
        }
        return dermatologistDTOS;
    }
}
