package dev.danvega.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.danvega.DTO.*;
import dev.danvega.Mapper.MedicationInfoMapper;
import dev.danvega.Mapper.MedicationMapper;
import dev.danvega.Model.*;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medication-info")
public class MedicationInfoController {

    @Autowired
    MedicationInfoService medicationInfoService = new MedicationInfoService();

    @Autowired
    MedicationService medicationService = new MedicationService();


    @Autowired
    ApotecaryService apotecaryService = new ApotecaryService();

    @Autowired
    MedicationActionService medicationActionService = new MedicationActionService();

    @Autowired
    MedicationSpecificationService medicationSpecificationService = new MedicationSpecificationService();

    private final MedicationInfoMapper medicationInfoMapper = new MedicationInfoMapper();

    @PostMapping("/add-new")
    @Transactional
    public ResponseEntity<String> add_new_medication_info(@RequestBody MedicationInfoDTO medicationInfoDTO)
    {
        MedicationInfo medInfo = medicationInfoMapper.toEntity(medicationInfoDTO);

        medInfo.setMedication(medicationService.findOne(medicationInfoDTO.getMedication_id()));
        medInfo.setApotecary(apotecaryService.findOne(medicationInfoDTO.getApotecary_id()));

        try {
            medicationInfoService.create(medInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Uspesno dodavanje nove medication info!", HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/get")
    public ResponseEntity<MedicationInfo> get(@RequestBody ApoMedIDDTO apoMedIDDTO){
        MedicationInfo medInfo = medicationInfoService.findByApotecary_IdAndMedication_Id(apoMedIDDTO.getApotecary_id(),apoMedIDDTO.getMedication_id());
        if(medInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(medInfo, HttpStatus.OK);
    }

    @PostMapping("/change-information")
    @Transactional
    public ResponseEntity<String> changeInformation(@RequestBody MedicationInfoDTO medicationInfoDTO) throws Exception {

        MedicationInfo medInf = medicationInfoService.findByApotecary_IdAndMedication_Id(medicationInfoDTO.getApotecary_id(), medicationInfoDTO.getMedication_id());

        if(medInf == null){
            Apotecary atemp = apotecaryService.findOne(medicationInfoDTO.getApotecary_id());
            Medication mtemp = medicationService.findOne(medicationInfoDTO.getMedication_id());
            MedicationInfo med = new MedicationInfo(medicationInfoDTO.getPrice(),medicationInfoDTO.getPriceDurationEndDate(),
                    medicationInfoDTO.getPriceDurationEndTime(),medicationInfoDTO.getInStorage(), atemp,mtemp);

            try{
                medicationInfoService.create(med);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>("Medication Info napravljen!", HttpStatus.OK);
        }
        else
        {
            medInf.setPrice(medicationInfoDTO.getPrice());
            medInf.setInStorage(medicationInfoDTO.getInStorage());
            medInf.setPriceDurationEndTime(medicationInfoDTO.getPriceDurationEndTime());
            medInf.setPriceDurationEndDate(medicationInfoDTO.getPriceDurationEndDate());

            try{
                medicationInfoService.update(medInf, medInf.getId());
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Uspesno ste promenili informacije", HttpStatus.OK);
        }


    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserIDDTO userIDDTO)
    {
        try{
            medicationInfoService.delete(userIDDTO.getId());
        }catch(Exception e){
            return new ResponseEntity<>("Postoji Medication Reservation vezan za ovaj Medication Info!",HttpStatus.OK);
        }
        return new ResponseEntity<>("Uspesno brisanje medication information!", HttpStatus.OK);

    }

    @Transactional
    @PostMapping("/get-all-admin")
    public ResponseEntity<List<MedicationAdminDTO>> get_all_admin(@RequestBody ApotecaryIDDTO apotecaryIDDTO){
        List<Medication> medications = medicationService.findAll();
        if(medications == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            List<MedicationInfo> medInfos = new ArrayList<>();
            List<MedicationSpecification> medicationSpecifications = new ArrayList<>();
            List<MedicationAction> medicationActions = new ArrayList<>();

            Medication medTemp;
            MedicationSpecification medSpecTemp;
            MedicationInfo medInfoTemp;
            MedicationAction medActionTemp;

            for(Medication med : medications)
            {
                medInfoTemp = medicationInfoService.findByApotecary_IdAndMedication_Id(apotecaryIDDTO.getId(),med.getId());

                if(medInfoTemp == null){
                    medInfoTemp = new MedicationInfo(0,null,null,0,null,null);
                }
                medActionTemp = medicationActionService.findAllByMedicationInfo_id(medInfoTemp.getId());
                if(medActionTemp == null){
                    medActionTemp = new MedicationAction(null,null,null,null,null,0);
                }

                medInfos.add(medInfoTemp);
                medicationSpecifications.add(medicationSpecificationService.findByMedication_Id(med.getId()));
                medicationActions.add(medActionTemp);
            }

            List<MedicationAdminDTO> medsReturn = new ArrayList<>();

            for (int i = 0; i < medications.size(); i++) {
                MedicationAdminDTO temp = new MedicationAdminDTO();

                medTemp = medications.get(i);
                medSpecTemp = medicationSpecifications.get(i);
                medInfoTemp = medInfos.get(i);
                medActionTemp = medicationActions.get(i);

                temp.setId(medTemp.getId());
                temp.setType(medTemp.getMedicationType().toString());
                temp.setName(medTemp.getName());

                temp.setComposition(medSpecTemp.getComposition());
                temp.setContradiction(medSpecTemp.getContradictions());
                temp.setDailyIntake(medSpecTemp.getDailyIntake());
                temp.setReplacement(medSpecTemp.getReplacementDrugs());

                temp.setInStorage(medInfoTemp.getInStorage());
                temp.setPrice(medInfoTemp.getPrice());
                temp.setPriceDurationEndTime(medInfoTemp.getPriceDurationEndTime());
                temp.setPriceDurationEndDate(medInfoTemp.getPriceDurationEndDate());

                temp.setProcentage(medActionTemp.getProcentage());

                temp.setApotecary_id(apotecaryIDDTO.getId());

                medsReturn.add(temp);
            }

            return new ResponseEntity<>(medsReturn, HttpStatus.OK);
        }
    }

    @Transactional
    @PostMapping("/get-all-admin-actions")
    public ResponseEntity<List<MedicationAdminActionDTO>> get_all_admin_actions(@RequestBody ApotecaryIDDTO apotecaryIDDTO){
        List<Medication> medications = medicationService.findAll();
        if(medications == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            List<MedicationInfo> medInfos = new ArrayList<>();
            List<MedicationAction> medicationActions = new ArrayList<>();

            Medication medTemp;
            MedicationInfo medInfoTemp;
            MedicationAction medActionTemp;

            for(Medication med : medications)
            {
                medInfoTemp = medicationInfoService.findByApotecary_IdAndMedication_Id(apotecaryIDDTO.getId(),med.getId());

                if(medInfoTemp == null){
                    medInfoTemp = new MedicationInfo(0,null,null,0,null,null);
                }
                medActionTemp = medicationActionService.findAllByMedicationInfo_id(medInfoTemp.getId());
                if(medActionTemp == null){
                    medActionTemp = new MedicationAction(null,null,null,null,null,0);
                }

                medInfos.add(medInfoTemp);
                medicationActions.add(medActionTemp);
            }

            List<MedicationAdminActionDTO> medsReturn = new ArrayList<>();

            for (int i = 0; i < medications.size(); i++) {
                if(medInfos.get(i).getApotecary() != null) {
                    MedicationAdminActionDTO temp = new MedicationAdminActionDTO();

                    medTemp = medications.get(i);
                    medInfoTemp = medInfos.get(i);
                    medActionTemp = medicationActions.get(i);

                    temp.setId(medInfoTemp.getId());
                    temp.setType(medTemp.getMedicationType().toString());
                    temp.setName(medTemp.getName());


                    temp.setInStorage(medInfoTemp.getInStorage());
                    temp.setPrice(medInfoTemp.getPrice());

                    temp.setProcentage(medActionTemp.getProcentage());
                    temp.setActionStartDate(medActionTemp.getActionStartDate());
                    temp.setActionStartTime(medActionTemp.getActionStartTime());
                    temp.setActionEndDate(medActionTemp.getActionEndDate());
                    temp.setActionEndTime(medActionTemp.getActionEndTime());

                    temp.setApotecary_id(apotecaryIDDTO.getId());

                    medsReturn.add(temp);
                }

            }

            return new ResponseEntity<>(medsReturn, HttpStatus.OK);
        }
    }

    @Transactional
    @PostMapping("/get-all")
    public ResponseEntity<List<MedicationAdminDTO>> get_all(@RequestBody ApotecaryIDDTO apotecaryIDDTO){
        List<Medication> medications = medicationService.findAll();
        if(medications == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{

            Medication medTemp = new Medication();
            MedicationSpecification medSpecTemp = new MedicationSpecification();
            MedicationInfo medInfoTemp = new MedicationInfo();
            MedicationAction medActionTemp;

            List<MedicationAdminDTO> medsReturn = new ArrayList<>();

            for(Medication med : medications)
            {
                medInfoTemp = medicationInfoService.findByApotecary_IdAndMedication_Id(apotecaryIDDTO.getId(),med.getId());

                if(medInfoTemp != null){
                    MedicationAdminDTO temp = new MedicationAdminDTO();

                    medTemp = med;
                    medSpecTemp = medicationSpecificationService.findByMedication_Id(med.getId());

                    medActionTemp = medicationActionService.findAllByMedicationInfo_id(medInfoTemp.getId());


                    temp.setId(medTemp.getId());
                    temp.setType(medTemp.getMedicationType().toString());
                    temp.setName(medTemp.getName());

                    temp.setComposition(medSpecTemp.getComposition());
                    temp.setContradiction(medSpecTemp.getContradictions());
                    temp.setDailyIntake(medSpecTemp.getDailyIntake());
                    temp.setReplacement(medSpecTemp.getReplacementDrugs());

                    temp.setInStorage(medInfoTemp.getInStorage());
                    temp.setPrice(medInfoTemp.getPrice());
                    temp.setPriceDurationEndTime(medInfoTemp.getPriceDurationEndTime());
                    temp.setPriceDurationEndDate(medInfoTemp.getPriceDurationEndDate());

                    temp.setApotecary_id(apotecaryIDDTO.getId());

                    if(medActionTemp != null) {
                        temp.setProcentage(medActionTemp.getProcentage());
                    }

                    medsReturn.add(temp);
                }
            }
            return new ResponseEntity<>(medsReturn, HttpStatus.OK);
        }
    }

}
