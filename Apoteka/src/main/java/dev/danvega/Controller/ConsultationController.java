package dev.danvega.Controller;

import dev.danvega.DTO.ApotecaryIDDTO;
import dev.danvega.DTO.ConsultationDTO;
import dev.danvega.DTO.VisitDTO;
import dev.danvega.Mapper.ConsultationMapper;
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

    private final ConsultationMapper consultationMapper = new ConsultationMapper();


    @PostMapping("new-consultation")
    @Transactional
    public ResponseEntity<String>new_counsultation(@RequestBody ConsultationDTO cDTO)
    {
        Pharmacist a = pharmacistService.findOne(cDTO.getPharmacist_id());
        Apotecary c = apotecaryService.findOne(cDTO.getApotecary_id());

        Consultation consultation = new Consultation(cDTO.getId(),cDTO.getStartDate(),cDTO.getStartTime(),cDTO.getDuration(),
                cDTO.getPrice(),cDTO.getStatus(),cDTO.getReport(),a,null, c);

        try{
            consultationService.create(consultation);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno ste zakazali novi pregled!", HttpStatus.CREATED);

    }

    @PostMapping("get-all-consultations")
    public ResponseEntity<List<ConsultationDTO>> get_all_visits(@RequestBody ApotecaryIDDTO apotecaryIDDTO)
    {
        List<Consultation> consultations = consultationService.findByApotecary_Id(apotecaryIDDTO.getId());
        if(consultations == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toVisitDTOList(consultations), HttpStatus.CREATED);
    }

    private List<ConsultationDTO> toVisitDTOList(List<Consultation> consultations){
        List<ConsultationDTO> consultationsDTOS = new ArrayList<>();
        for (Consultation consultation : consultations) {
            consultationsDTOS.add(consultationMapper.toDto(consultation));
        }
        return consultationsDTOS;
    }

}
