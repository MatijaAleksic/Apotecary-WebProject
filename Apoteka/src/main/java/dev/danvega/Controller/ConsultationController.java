package dev.danvega.Controller;

import dev.danvega.DTO.ConsultationDTO;
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
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    ConsultationService consultationService = new ConsultationService();
    @Autowired
    PharmacistService  pharmacistService = new PharmacistService();
    @Autowired
    PatientService patientService = new PatientService();
    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();
    @Autowired
    MedicationReservationService medicationReservationService = new MedicationReservationService();

    @PostMapping("new-consultation")
    @Transactional
    public ResponseEntity<String>new_counsultation(@RequestBody ConsultationDTO cDTO)
    {
        System.out.println(cDTO.getId());
        System.out.println(cDTO.getPatient_id());
        System.out.println(cDTO.getApotecary_id());
        Pharmacist a = pharmacistService.findOne(cDTO.getPharmacist_id());
        Patient b = patientService.findOne(cDTO.getPatient_id());
        Apotecary c = apotecaryService.findOne(cDTO.getApotecary_id());

        Consultation consultation = new Consultation(cDTO.getId(),cDTO.getStartDate(),cDTO.getStartTime(),cDTO.getDuration(),
                cDTO.getPrice(),cDTO.getStatus(),cDTO.getReport(),a,b, c);

        try{
            consultationService.create(consultation);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno ste zakazali novi pregled!", HttpStatus.CREATED);

    }

}
