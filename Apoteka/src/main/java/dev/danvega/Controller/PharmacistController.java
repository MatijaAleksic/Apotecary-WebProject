package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.*;
import dev.danvega.Model.*;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pharmacist")
public class PharmacistController {

    @Autowired
    VacationPharmacistService vacationPharmacistService = new VacationPharmacistService();
    @Autowired
    PharmacistService pharmacistService = new PharmacistService();
    @Autowired
    ConsultationService consultationService = new ConsultationService();
    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();
    @Autowired
    PharmacistRatingService pharmacistRatingService = new PharmacistRatingService();

    private final PharmacistMapper pharmacistMapper = new PharmacistMapper();
    private final PharmacistPatientsMapper pharmacistPatientsMapper = new PharmacistPatientsMapper();
    private final VacationPharmacistMapper vacationPharmacistMapper = new VacationPharmacistMapper();
    private final ConsultationMapper consultationMapper = new ConsultationMapper();

    @PostMapping("/view-patients")
    public ResponseEntity<List<PatientDTO>> view_patients(@RequestBody UserIDDTO id)
    {
        List<Patient> patients = consultationService.viewPatients(id.getId());
        if(patients == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(toPatientDTOList(patients));
    }

    @PostMapping("/get-one")
    public ResponseEntity<PharmacistDTO> getOne(@RequestBody UserIDDTO userIDDTO){
        try{
            if(pharmacistService.findOne(userIDDTO.getId()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else
            {
                return new ResponseEntity<>(pharmacistMapper.toDTO(pharmacistService.findOne(userIDDTO.getId())), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/get-apotecary-id")
    public ResponseEntity<Long> get_apotecary(@RequestBody UserIDDTO userIDDTO)
    {
        Pharmacist pharmacist;
        try {
            pharmacist = pharmacistService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pharmacist.getApotecary().getId(), HttpStatus.OK);
    }

    @PostMapping("/get-personal-info")
    public ResponseEntity<PharmacistDTO> get_personal_info(@RequestBody UserIDDTO userIDDTO)
    {
        Pharmacist pharm;
        try {
            pharm = pharmacistService.findOne(userIDDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pharmacistMapper.toDTO(pharm), HttpStatus.OK);
    }

    @PostMapping("/change-information")
    public ResponseEntity<String> changeInformation(@RequestBody PhrmacistChangeInfo pci){
        Pharmacist pharmacist = new Pharmacist(pci.getId(), pci.getName(), pci.getLastName(), pci.getCity(),pci.getAddress(), pci.getPhone(), pci.getCountry());

        try{
            pharmacist = pharmacistService.updateInfo(pharmacist);
        } catch (Exception e) {
            e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest cpr){
        Pharmacist pharm = new Pharmacist(cpr.getId(), cpr.getNewPassword());
        try{
            pharmacistService.updatePassword(cpr.getId(),cpr.getNewPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>("Uspesno ste promenili sifru", HttpStatus.OK);
    }

    @PostMapping("get-all-consultations")
    public ResponseEntity<List<ConsultationDTO>> get_all_visits(@RequestBody PharmaApotecaryDTO pa)
    {
        List<Consultation> consultations = consultationService.findByApotecary_IdAnd_Pharmacist_Id(pa.getApotecaryId(),pa.getPharmaId());
        if(consultations == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toConsultationDTOList(consultations), HttpStatus.CREATED);
    }

    @PostMapping("/vacation")
    public ResponseEntity<String>request_vacation(@RequestBody VacationPharmacistDTO vacationPharmacistDTO)
    {
        System.out.println(vacationPharmacistDTO.getPharmacist_id());
        VacationPharmacist vacationPharmacist = new VacationPharmacist(vacationPharmacistDTO.getPharmacist_id(),
                vacationPharmacistDTO.getStartDate(), vacationPharmacistDTO.getFinishDate(), vacationPharmacistDTO.getDescription(),
                StatusCV.PENDING);


        vacationPharmacist.setPharmacist(pharmacistService.findOne(vacationPharmacistDTO.getPharmacist_id()));

        try{
            vacationPharmacistService.create(vacationPharmacist);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Uspesno ste poslali zahtev za godisnji odmor!", HttpStatus.CREATED);
    }

    @PostMapping("/register-new")
    @Transactional
    public ResponseEntity<String> register_pharmacist(@RequestBody PharmacistDTO pharmacistDTO)
    {
        Pharmacist pharmacist = pharmacistMapper.toEntityDTO(pharmacistDTO);

        pharmacist.setApotecary(apotecaryService.findOne(pharmacistDTO.getApotecary_id()));
        pharmacist.setFirstTimeLogin(true);

        try {
            pharmacistService.create(pharmacist);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno registrovan farmaceut!", HttpStatus.CREATED);
    }

    @PostMapping("/change-informations")
    public ResponseEntity<String> changeInformation(@RequestBody DermatologistChangeInfoDTO pci){
        Pharmacist pharm = new Pharmacist(pci.getId(), pci.getName(), pci.getLastName(), pci.getCity(),pci.getAddress(), pci.getPhone(), pci.getCountry());
        try{
            pharmacistService.updateInfo(pharm);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili informacije", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PharmacistDTO>> get_all()
    {
        List<Pharmacist> pharmacists = pharmacistService.findAll();
        if(pharmacists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toPharmacistDTOList(pharmacists), HttpStatus.OK);
    }

    @PostMapping("/get-all-admin")
    public ResponseEntity<List<PharmacistDTO>> get_all_admin(@RequestBody ApotecaryIDDTO apotecaryIDDTO){
        List<Pharmacist> pharmacists = pharmacistService.findAllByApotecaryId(apotecaryIDDTO.getId());
        if(pharmacists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toPharmacistDTOList(pharmacists), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserIDDTO userIDDTO)
    {
        try{
            pharmacistService.delete(userIDDTO.getId());
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Uspesno brisanje farmaceuta!", HttpStatus.OK);

    }

    private List<PharmacistDTO> toPharmacistDTOList(List<Pharmacist> pharmacists){
        List<PharmacistDTO> pharmacistDTOS = new ArrayList<>();
        PharmacistDTO temp;

        for (Pharmacist pharma : pharmacists) {
            temp = pharmacistMapper.toDTO(pharma);
            System.out.println(pharmacistRatingService.findRatingByPharmacist(pharma.getId()) + "HELLO");
            temp.setPharmacistRating(pharmacistRatingService.findRatingByPharmacist(pharma.getId()));
            pharmacistDTOS.add(temp);
        }
        return pharmacistDTOS;
    }

    private List<PatientDTO> toPatientDTOList(List<Patient> patients){
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(pharmacistPatientsMapper.toDto(patient));
        }
        return patientDTOS;
    }

    private List<ConsultationDTO> toConsultationDTOList(List<Consultation> consultations){
        List<ConsultationDTO> consultationsDTOS = new ArrayList<>();
        for (Consultation consultation : consultations) {
            consultationsDTOS.add(consultationMapper.toDto(consultation));
        }
        return consultationsDTOS;
    }
}
