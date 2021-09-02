package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.AdministratorMapper;
import dev.danvega.Mapper.PatienteMapper;
import dev.danvega.Model.*;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Services.ChangeInformation;
import dev.danvega.Services.ConsultationService;
import dev.danvega.Services.PatientService;
import dev.danvega.Services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patient")


public class PatientController {

    @Autowired
    PatientService patientService = new PatientService();

    @Autowired
    VisitService visitService = new VisitService();

    @Autowired
    ConsultationService consultationService = new ConsultationService();

    PatienteMapper patientMapper = new PatienteMapper();


    ChangeInformation change = new ChangeInformation();

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody AdminChangeInfo cir){
        Patient patient = new Patient(cir.getId(), cir.getFirstname(), cir.getLastname(), cir.getAddress(),
                cir.getCity(),cir.getCountry(), cir.getPhone());
        try{
            patientService.updateInfo(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("/book-event")
    public ResponseEntity<String> bookEvent(@RequestBody BookEventDTO bookEvent){

        if(bookEvent.getKategorija().equals("Poseta")){
            Visit temp = visitService.findOne(bookEvent.getEventId());
            if(temp.getStatus().equals(StatusCV.ACCEPTED)){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

            temp.setPatient(patientService.findOne(bookEvent.getPatId()));
            temp.setStatus(StatusCV.ACCEPTED);

            try{
                visitService.update(temp, bookEvent.getEventId());
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>("Uspesno zakazivanje posete!", HttpStatus.OK);
        }
        else if(bookEvent.getKategorija().equals("Konsultacija"))
        {
            Consultation temp = consultationService.findOne(bookEvent.getEventId());
            if(temp.getStatus().equals(StatusCV.ACCEPTED)){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

            temp.setPatient(patientService.findOne(bookEvent.getPatId()));
            temp.setStatus(StatusCV.ACCEPTED);

            try{
                consultationService.update(temp, bookEvent.getEventId());
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>("Uspesno zakazivanje konsultacije!", HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        Patient patient = new Patient(cpr.getId(), cpr.getNewPassword());
        try{
            patientService.updatePassword(patient);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
    }

    @PostMapping("/get-personal-info")
    public ResponseEntity<PatientDTO> get_personal_info(@RequestBody UserIDDTO userIDDTO)
    {
        Patient patient;
        try {
            patient = patientService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patientMapper.toDto(patient), HttpStatus.OK);
    }

    @PostMapping("/get-events")
    @Transactional
    public ResponseEntity<List<EventDTO>> get_events(@RequestBody UserIDDTO userIDDTO)
    {
        List<Visit> posete = visitService.findByPatient_Id(userIDDTO.getId());
        List<Consultation> konsultacije = consultationService.findByPatient_Id((userIDDTO.getId()));
        List<EventDTO> returnLista = new ArrayList<>();

        EventDTO temp;
        for(Visit poseta : posete){
            temp = new EventDTO(poseta.getId(),poseta.getStartDate(),poseta.getStartTime(),poseta.getDuration(),poseta.getPrice()
                    ,poseta.getReport(),poseta.getDermatologist().getFirstname(), poseta.getDermatologist().getFirstname(), "Poseta");
            returnLista.add(temp);
        }
        for(Consultation konsultacija : konsultacije){
            temp = new EventDTO(konsultacija.getId(),konsultacija.getStartDate(),konsultacija.getStartTime(),konsultacija.getDuration(),konsultacija.getPrice()
                    ,konsultacija.getReport(),konsultacija.getPharmacist().getFirstname(), konsultacija.getPharmacist().getLastname(), "Konsultacija");
            returnLista.add(temp);
        }

        return new ResponseEntity<>(returnLista, HttpStatus.OK);
    }

}


