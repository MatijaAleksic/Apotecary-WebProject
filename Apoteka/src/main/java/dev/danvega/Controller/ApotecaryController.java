package dev.danvega.Controller;

import dev.danvega.DTO.ApothecaryDTO;
import dev.danvega.Mapper.ApothecaryMapper;
import dev.danvega.Model.Apotecary;
import dev.danvega.Services.ApotecaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ApothecaryDTO>> apothecaryList(@PathVariable String name, @PathVariable String adress){
        List<Apotecary> apothecaries = apothecaryService.searchApothecary(name, adress);
        if(apothecaries == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toApothecaryDTOList(apothecaries));
    }

    //pokusaj
    @GetMapping(value="/list")
    public ResponseEntity<List<ApothecaryDTO>> listApothecaries(){
        List<Apotecary> apothecaries = apothecaryService.findAll();
        if (apothecaries == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toApothecaryDTOList(apothecaries));
    }

    private List<ApothecaryDTO> toApothecaryDTOList(List<Apotecary> apothecaries){
        List<ApothecaryDTO> apothecaryDTOS = new ArrayList<>();
        for (Apotecary apothecary : apothecaries){
            apothecaryDTOS.add(apothecaryMapper.toDto(apothecary));
        }
        return apothecaryDTOS;
    }

}
