package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.DermatologistSearchMapper;
import dev.danvega.Mapper.VisitMapper;
import dev.danvega.Model.*;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/visit")
public class VisitController {

    @Autowired
    VisitService visitService = new VisitService();
    @Autowired
    DermathologistService dermathologistService = new DermathologistService();
    @Autowired
    PatientService patientService = new PatientService();
    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();
    @Autowired
    MedicationReservationService medicationReservationService = new MedicationReservationService();

    private final VisitMapper visitMapper = new VisitMapper();

    @PostMapping("new-visit")
    @Transactional
    public ResponseEntity<String> new_visit(@RequestBody VisitDTO vDTO)
    {

        Dermatologist a = dermathologistService.findOne(vDTO.getDermatologis_id());
        Patient b = patientService.findOne(vDTO.getPatient_id());
        Apotecary c = apotecaryService.findOne(vDTO.getApotecary_id());

        Visit visit = new Visit(vDTO.getId(),vDTO.getStartDate(),vDTO.getStartTime(),vDTO.getDuration(),
                vDTO.getPrice(),vDTO.getStatus(),vDTO.getReport(),a,b, c);

        try{
            visitService.create(visit);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno ste zakazali novi pregled!", HttpStatus.CREATED);

    }

    @PostMapping("get-all-visits")
    public ResponseEntity<List<VisitDTO>> get_all_visits(@RequestBody ApotecaryIDDTO apotecaryIDDTO)
    {
        List<Visit> visits = visitService.findByApotecary_Id(apotecaryIDDTO.getId());
        if(visits == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toVisitDTOList(visits), HttpStatus.CREATED);
    }

    private List<VisitDTO> toVisitDTOList(List<Visit> visits){
        List<VisitDTO> visitsDTOS = new ArrayList<>();
        for (Visit visit : visits) {
            visitsDTOS.add(visitMapper.toDto(visit));
        }
        return visitsDTOS;
    }
}
