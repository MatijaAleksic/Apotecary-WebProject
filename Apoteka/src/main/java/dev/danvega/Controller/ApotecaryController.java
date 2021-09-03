package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.ApothecaryMapper;
import dev.danvega.Model.Administrator;
import dev.danvega.Model.Apotecary;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Patient;
import dev.danvega.Services.ApotecaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/apotecary")
public class ApotecaryController {

    @Autowired
    ApotecaryService apothecaryService = new ApotecaryService();

    private final ApothecaryMapper apothecaryMapper = new ApothecaryMapper();

    @RequestMapping(value="/apothecary-list/name={name}&address={adress}", method = RequestMethod.GET)
    public ResponseEntity<List<ApotecaryDTO>> apothecaryList(@PathVariable String name, @PathVariable String adress){
        List<Apotecary> apothecaries = apothecaryService.searchApothecary(name, adress);
        if(apothecaries == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toApothecaryDTOList(apothecaries));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/get-info")
    public ResponseEntity<ApotecaryDTO> get_info(@RequestBody ApotecaryIDDTO apotecaryIDDTO)
    {
        Apotecary apotecary;
        try {
            apotecary = apothecaryService.findOne(apotecaryIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ApotecaryDTO apoDTO = apothecaryMapper.toDto(apotecary);
        apoDTO.setRating(apothecaryService.findRatingByApotecary(apotecaryIDDTO.getId()));
        return new ResponseEntity<>(apoDTO, HttpStatus.OK);
    }

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody ApotecaryDTO apotecaryDTO){

        Apotecary apo = new Apotecary(apotecaryDTO.getId(), apotecaryDTO.getName(), apotecaryDTO.getAdress(), apotecaryDTO.getDescription());
        try{
            apothecaryService.update(apo, apotecaryDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ApotecaryDTO>> get_all(){
        List<Apotecary> apotecaries = apothecaryService.findAll();
        if(apotecaries == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toApothecaryDTOList(apotecaries), HttpStatus.OK);
    }


    private List<ApotecaryDTO> toApothecaryDTOList(List<Apotecary> apothecaries){
        List<ApotecaryDTO> apothecaryDTOS = new ArrayList<>();
        ApotecaryDTO temp;

        for (Apotecary apothecary : apothecaries){
            temp = apothecaryMapper.toDto(apothecary);
            temp.setRating(apothecaryService.findRatingByApotecary(apothecary.getId()));

            apothecaryDTOS.add(apothecaryMapper.toDto(apothecary));
        }
        return apothecaryDTOS;
    }

}
