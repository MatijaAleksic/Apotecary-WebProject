package dev.danvega.Controller;

import dev.danvega.DTO.ConsultationDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.DTO.VisitDTO;
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

    @PostMapping("new-visit")
    @Transactional
    public ResponseEntity<String> new_visit(@RequestBody VisitDTO vDTO)
    {
        Dermatologist a = dermathologistService.findOne(vDTO.getDermatologis_id());
        Patient b = patientService.findOne(vDTO.getPatient_id());
        Apotecary c = apotecaryService.findOne(vDTO.getApotecary_id());
        MedicationReservation mc = medicationReservationService.findOne(vDTO.getMedication_reservation_id());
        Visit visit = new Visit(vDTO.getId(),vDTO.getStartDate(),vDTO.getStartTime(),vDTO.getDuration(),
                vDTO.getPrice(),vDTO.getStatus(),vDTO.getReport(),a,b, c,mc);

        try{
            visitService.create(visit);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno ste zakazali novi pregled!", HttpStatus.CREATED);

    }
}
