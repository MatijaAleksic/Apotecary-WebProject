package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.DermatologistSearchMapper;
import dev.danvega.Mapper.MedicationListMapper;
import dev.danvega.Mapper.MedicationMapper;
import dev.danvega.Model.Alergies;
import dev.danvega.Model.Dermatologist;
import dev.danvega.Model.Medication;
import dev.danvega.Model.Visit;
import dev.danvega.Services.AlergiesService;
import dev.danvega.Services.MedicationService;
import dev.danvega.Services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService = new MedicationService();
    @Autowired
    AlergiesService alergiesService = new AlergiesService();

    private final MedicationMapper medicationMapper = new MedicationMapper();
    private final MedicationListMapper medicationListMapper = new MedicationListMapper();

    @PostMapping("/add-new")
    public ResponseEntity<Long> add_new_medication(@RequestBody MedicationDTO medicationDTO)
    {
        Medication med = medicationMapper.toEntity(medicationDTO);
        Medication returnMed;

        try {
            returnMed = medicationService.create(med);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(returnMed.getId(), HttpStatus.CREATED);
    }

    @PostMapping("medication-alergies")
    @Transactional
    public ResponseEntity<List<MedicationListDTO>> list_alergies_medication(@RequestBody UserIDDTO id)
    {
        List<Medication> medications = medicationService.findAll();
        List<Alergies> alergies = alergiesService.findALlByPatient_Id(id.getId());

        System.out.println(alergies);
        System.out.println(medications);
        List<Medication> allowed = new ArrayList<>();
        ArrayList<Long> medicationI = new ArrayList<>();
        try{
                for(Alergies y : alergies){
                    medicationI.add(y.getMedication().getId());
                }
                for(Medication x : medications){
                    if(!medicationI.contains(x.getId())){
                        allowed.add(x);

                    }
                }
            System.out.println(allowed);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(toMedicationListDTO(allowed),HttpStatus.OK);
    }

    private List<MedicationListDTO> toMedicationListDTO(List<Medication> medications){
        List<MedicationListDTO> medicationListDTOS = new ArrayList<>();
        for (Medication med : medications) {
            medicationListDTOS.add(medicationListMapper.toDto(med));
        }
        return medicationListDTOS;
    }
}
