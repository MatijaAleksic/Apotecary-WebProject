package dev.danvega.Controller;

import dev.danvega.DTO.DermatologistDTO;
import dev.danvega.DTO.DermatologistSearchDTO;
import dev.danvega.DTO.MedicationInquiryDTO;
import dev.danvega.DTO.UserIDDTO;
import dev.danvega.Mapper.MedicationInquiryMapper;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Model.MedicationInquiry;
import dev.danvega.Services.MedicationInfoService;
import dev.danvega.Services.MedicationInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medication_inquiry")
public class MedicationInquiryController {

    @Autowired
    MedicationInquiryService medicationInquiryService = new MedicationInquiryService();

    @Autowired
    MedicationInfoService medicationInfoService = new MedicationInfoService();

    private final MedicationInquiryMapper medicationInquiryMapper = new MedicationInquiryMapper();


    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserIDDTO userIDDTO)
    {
        try{
            medicationInquiryService.delete(userIDDTO.getId());
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Uspesno brisanje upita za lekove!", HttpStatus.OK);

    }

    @PostMapping("/accept")
    public ResponseEntity<String> accept(@RequestBody MedicationInquiryDTO medicationInquiryDTO)
    {
        try{
            MedicationInfo existingMedicalInfo = medicationInfoService.findByApotecary_IdAndMedication_Id(medicationInquiryDTO.getApotecary_id(), medicationInquiryDTO.getMedication_id());
            if(existingMedicalInfo == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            existingMedicalInfo.setInStorage(existingMedicalInfo.getInStorage() + medicationInquiryDTO.getQuantity());
            medicationInfoService.update(existingMedicalInfo, existingMedicalInfo.getId());

            medicationInquiryService.delete(medicationInquiryDTO.getId());
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Uspesno dodavanje nove narudzbenice!", HttpStatus.OK);

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MedicationInquiryDTO>> get_all(){
        List<MedicationInquiry> medicationInquiries = medicationInquiryService.findAll();
        if(medicationInquiries == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toMedicationInquiryDTOList(medicationInquiries), HttpStatus.OK);
    }

    private List<MedicationInquiryDTO> toMedicationInquiryDTOList(List<MedicationInquiry> medicationInquiries){
        List<MedicationInquiryDTO> medicationInquiryDTOS = new ArrayList<>();
        for (MedicationInquiry medicationInquiry : medicationInquiries) {
            medicationInquiryDTOS.add(medicationInquiryMapper.toDto(medicationInquiry));
        }
        return medicationInquiryDTOS;
    }
}
