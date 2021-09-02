package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.*;
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
    private final VisitMapper visitMapper = new VisitMapper();
    private final VisitTableMapper visitTableMapper = new VisitTableMapper();



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
        try{
            dermathologistService.updateInfo(dermatologist);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("get-all-visits")
    public ResponseEntity<List<VisitDTO>> get_all_visits(@RequestBody DermaApotecaryDTO da)
    {
        List<Visit> visits = visitService.findByApotecary_IdAnd_Dermatologist_Id(da.getApotecaryID(),da.getDermaID());
        if(visits == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toVisitDTOList(visits), HttpStatus.CREATED);
    }
    @PostMapping("get-all-visits-table")
    @Transactional
    public ResponseEntity<List<VisitTableDTO>> get_all_visits_table(@RequestBody DermaApotecaryDTO da)
    {
        System.out.println(da.apotecaryID);
        System.out.println(da.dermaID);
        List<Visit> visits = visitService.findByApotecary_IdAnd_Dermatologist_Id(da.getApotecaryID(),da.getDermaID());
        if(visits == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toVisitTableDTOList(visits), HttpStatus.CREATED);
    }


    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        Dermatologist dermatologist = new Dermatologist(cpr.getId(), cpr.getNewPassword());
        try{
            System.out.println(cpr.getId());
            System.out.println(cpr.getNewPassword());
            dermathologistService.updatePassword(cpr.getId(),cpr.getNewPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>("Uspesno ste promenili sifru", HttpStatus.OK);
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

    @PostMapping("/get-personal-info")
    public ResponseEntity<DermatologistDTO> get_personal_info(@RequestBody UserIDDTO userIDDTO)
    {
        Dermatologist derma;
        try {
            derma = dermathologistService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dermatologistMapper.toDto(derma), HttpStatus.OK);
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

    @PostMapping("/get-one")
    public ResponseEntity<DermatologistDTO> getOne(@RequestBody UserIDDTO userIDDTO){
        try{
            if(dermathologistService.findOne(userIDDTO.getId()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(dermatologistMapper.toDto(dermathologistService.findOne(userIDDTO.getId())), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    private List<VisitDTO> toVisitDTOList(List<Visit> visits){
        List<VisitDTO> visitsDTOS = new ArrayList<>();
        for (Visit visit : visits) {
            visitsDTOS.add(visitMapper.toDto(visit));
        }
        return visitsDTOS;
    }

    private List<VisitTableDTO> toVisitTableDTOList(List<Visit> visits){
        List<VisitTableDTO> visitsDTOS = new ArrayList<>();
        for (Visit visit : visits) {
            visitsDTOS.add(visitTableMapper.toDto(visit));
        }
        return visitsDTOS;
    }

}