package dev.danvega.Controller;

import dev.danvega.DTO.MedicationActionDTO;
import dev.danvega.DTO.UserIDDTO;
import dev.danvega.Mapper.MedicationActionMapper;
import dev.danvega.Model.MedicationAction;
import dev.danvega.Model.MedicationInfo;
import dev.danvega.Services.MedicationActionService;
import dev.danvega.Services.MedicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medication_action")
public class MedicationActionController {

    @Autowired
    MedicationActionService medicationActionService = new MedicationActionService();

    @Autowired
    MedicationInfoService medicationInfoService = new MedicationInfoService();

    private final MedicationActionMapper medicationActionMapper = new MedicationActionMapper();


    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserIDDTO userIDDTO)
    {
        try{
            medicationActionService.delete(userIDDTO.getId());
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("Uspesno brisanje akcije!", HttpStatus.OK);

    }

    @PostMapping("/add-new")
    @Transactional
    public ResponseEntity<String> addNew(@RequestBody MedicationActionDTO medicationActionDTO)
    {
        try{
            MedicationAction existingMedicationAction = medicationActionService.findAllByMedicationInfo_id(medicationActionDTO.getMedicationInfo_id());
            if(existingMedicationAction == null){

                MedicationInfo medInfoTemp = medicationInfoService.findOne(medicationActionDTO.getMedicationInfo_id());
                MedicationAction newAction = medicationActionMapper.toEntity(medicationActionDTO, medInfoTemp);
                medicationActionService.create(newAction);

                return new ResponseEntity<>("Uspesno kreirana nova akcija", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Vec postoji akcija za dati lek!", HttpStatus.NOT_ACCEPTABLE);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MedicationActionDTO>> get_all(){
        List<MedicationAction> medicationActions = medicationActionService.findAll();
        if(medicationActions == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toMedicationInquiryDTOList(medicationActions), HttpStatus.OK);
    }

    private List<MedicationActionDTO> toMedicationInquiryDTOList(List<MedicationAction> medicationActions){
        List<MedicationActionDTO> medicationActionDTOS = new ArrayList<>();
        for (MedicationAction medicationAction : medicationActions) {
            medicationActionDTOS.add(medicationActionMapper.toDto(medicationAction));
        }
        return medicationActionDTOS;
    }
}
