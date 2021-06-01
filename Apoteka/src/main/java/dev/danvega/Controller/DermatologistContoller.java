package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Mapper.DermatologistPatientsMapper;
import dev.danvega.Mapper.DermatologistSearchMapper;
import dev.danvega.Model.*;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dermatologist")
public class DermatologistContoller {

    @Autowired
    VacationDermatologistService vacationDermatologistService = new VacationDermatologistService();
    @Autowired
    DermathologistService dermathologistService = new DermathologistService();

    @Autowired
    DermatologistRatingService dermatologistRatingService = new DermatologistRatingService();

    @Autowired
    VisitService visitService = new VisitService();

    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();

    private final DermatologistSearchMapper dermatologistSearchMapper = new DermatologistSearchMapper();
    private final DermatologistMapper dermatologistMapper = new DermatologistMapper();
    private final DermatologistPatientsMapper dermatologistPatientsMapper = new DermatologistPatientsMapper();

    @RequestMapping(value="search/name={firstname}&lastname={lastname}", method=RequestMethod.GET)
    public ResponseEntity<List<DermatologistSearchDTO>> searchDermatologist(@PathVariable String firstname, @PathVariable String lastname){
        List<Dermatologist> dermatologists = dermathologistService.searchDermatologist(firstname,lastname);
        if(dermatologists == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(toDermatologistSearchDTOList(dermatologists));
    }

    @PostMapping("/get-apotecary-id")
    public ResponseEntity<Long> get_apotecary(@RequestBody UserIDDTO userIDDTO)
    {
        Dermatologist dermatologist;
        try {
            dermatologist = dermathologistService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dermatologist.getApotecary().getId(), HttpStatus.OK);
    }

    @PostMapping("/vacation")
    public ResponseEntity<String>request_vacation(@RequestBody VacationDermatologistDTO vacationDermatologistDTO)
    {
        System.out.println(vacationDermatologistDTO.getStartDate());
        System.out.println(vacationDermatologistDTO.getFinishDate());
        System.out.println(vacationDermatologistDTO.getDescription());
        VacationDermatologist vacationDermatologist = new VacationDermatologist(vacationDermatologistDTO.getDermatologist_id(),
                vacationDermatologistDTO.getStartDate(), vacationDermatologistDTO.getFinishDate(), vacationDermatologistDTO.getDescription(),
                StatusCV.PENDING);


        vacationDermatologist.setDermatologist(dermathologistService.findOne(vacationDermatologistDTO.getDermatologist_id()));

        try{
            vacationDermatologistService.create(vacationDermatologist);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno ste poslali zahtev za godisnji odmor!", HttpStatus.CREATED);
    }

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody DermatologistChangeInfoDTO pci){
        Dermatologist dermatologist = new Dermatologist(pci.getId(), pci.getName(), pci.getLastName(), pci.getCity(),pci.getAddress(), pci.getPhone(), pci.getCountry());
        System.out.println(dermatologist.getId());
        try{
            dermatologist = dermathologistService.updateInfo(dermatologist);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        System.out.println(cpr.getId());
        Dermatologist dermatologist = new Dermatologist(cpr.getId(), cpr.getNewPassword());
        try{
            System.out.println(dermatologist.getId());
            dermatologist = dermathologistService.updatePassword(dermatologist);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
    }

    @PostMapping("/view-patients")
    @Transactional
    public ResponseEntity<List<PatientDTO>> view_patients(@RequestBody UserIDDTO id)
    {
        List<Patient> patients = visitService.viewPatients(id.getId());
        if(patients == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(toPatientDTOList(patients));
    }

    @PostMapping("/register-new")
    public ResponseEntity<String> register_dermatologist(@RequestBody DermatologistDTO dermatologistDTO)
    {
        Dermatologist derma = dermatologistMapper.toEntity(dermatologistDTO);
        derma.setApotecary(apotecaryService.findOne(dermatologistDTO.getApotecary_id()));
        derma.setFirstTimeLogin(true);

        try {
            dermathologistService.create(derma);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno registrovan dermatolog!", HttpStatus.CREATED);
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<DermatologistDTO>> get_all(){
        List<Dermatologist> dermatologists = dermathologistService.findAll();
        if(dermatologists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toDermatologistDTOList(dermatologists), HttpStatus.OK);
    }

    @PostMapping("/get-all-admin")
    public ResponseEntity<List<DermatologistDTO>> get_all_admin(@RequestBody ApotecaryIDDTO apotecaryIDDTO){
        List<Dermatologist> dermatologists = dermathologistService.findAllByApotecaryId(apotecaryIDDTO.getId());
        if(dermatologists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toDermatologistDTOList(dermatologists), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserIDDTO userIDDTO)
    {
        try{
            dermathologistService.delete(userIDDTO.getId());
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Uspesno brisanje dermatologa!", HttpStatus.OK);

    }

    private List<DermatologistDTO> toDermatologistDTOList(List<Dermatologist> dermatologists){
        List<DermatologistDTO> dermatologistDTOS = new ArrayList<>();
        DermatologistDTO temp;

        for (Dermatologist dermatologist : dermatologists) {
            temp = dermatologistMapper.toDto(dermatologist);
            temp.setDermatologistRating(dermatologistRatingService.findRatingByDermatologist(dermatologist.getId()));
            dermatologistDTOS.add(temp);
        }
        return dermatologistDTOS;
    }

    private List<DermatologistSearchDTO> toDermatologistSearchDTOList(List<Dermatologist> dermatologists){
        List<DermatologistSearchDTO> dermatologistDTOS = new ArrayList<>();
        for (Dermatologist dermatologist : dermatologists) {
            dermatologistDTOS.add(dermatologistSearchMapper.toDto(dermatologist));
        }
        return dermatologistDTOS;
    }

    private List<PatientDTO> toPatientDTOList(List<Patient> patients){
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(dermatologistPatientsMapper.toDto(patient));
        }
        return patientDTOS;
    }
}