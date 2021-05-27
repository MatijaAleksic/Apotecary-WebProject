package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.DermatologistMapper;
import dev.danvega.Mapper.PharmacistMapper;
import dev.danvega.Mapper.PharmacistPatientsMapper;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Patient;
import dev.danvega.Model.Pharmacist;
import dev.danvega.Services.ApotecaryService;
import dev.danvega.Services.ConsultationService;
import dev.danvega.Services.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pharmacist")
public class PharmacistController {

    @Autowired
    PharmacistService pharmacistService = new PharmacistService();
    @Autowired
    ConsultationService consultationService = new ConsultationService();
    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();

    private final PharmacistMapper pharmacistMapper = new PharmacistMapper();
    private final PharmacistPatientsMapper pharmacistPatientsMapper = new PharmacistPatientsMapper();

    @PostMapping("/view-patients")
    public ResponseEntity<List<PatientDTO>> view_patients(@RequestBody UserIDDTO id)
    {
        List<Patient> patients = consultationService.viewPatients(id.getId());
        if(patients == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(toPatientDTOList(patients));
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
        System.out.println(cpr.getId());
        Pharmacist pharmacist = new Pharmacist(cpr.getId(), cpr.getNewPassword());
        try{
            System.out.println(pharmacist.getId());
            pharmacist = pharmacistService.updatePassword(pharmacist);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<String>("Uspesno ste promenili sifru", HttpStatus.OK);
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
        for (Pharmacist pharma : pharmacists) {
            pharmacistDTOS.add(pharmacistMapper.toDTO(pharma));
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
}
