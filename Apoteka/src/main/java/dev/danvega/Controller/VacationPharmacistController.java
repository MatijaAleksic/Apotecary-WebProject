package dev.danvega.Controller;

import dev.danvega.DTO.*;
import dev.danvega.Mapper.*;
import dev.danvega.Model.*;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pharmacist-vacation")
public class VacationPharmacistController {

    @Autowired
    VacationPharmacistService vacationPharmacistService  = new VacationPharmacistService();

    private final VacationPharmacistMapper vacationPharmacistMapper = new VacationPharmacistMapper();


    @Transactional
    @PostMapping("/get-all-admin")
    public ResponseEntity<List<VacationPharmacistDTO>> get_all_admin(@RequestBody ApotecaryIDDTO apotecaryIDDTO) {

        List<VacationPharmacist> vacations = vacationPharmacistService.findAll();
        if (vacations == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<VacationPharmacist> vacationsAdmin = new ArrayList<>();

            for (VacationPharmacist vac : vacations) {

                if (vac.getPharmacist().getApotecary().getId().equals(apotecaryIDDTO.getId())) {
                    vacationsAdmin.add(vac);
                }
            }
            return new ResponseEntity<>(toVacationPharmacistDTOList(vacationsAdmin), HttpStatus.OK);
        }
    }

    @PostMapping("/vacation-response")
    public ResponseEntity<String> response_to_vacation(@RequestBody VacationResponseDTO vacationResponseDTO) {
        try{
            VacationPharmacist vac = vacationPharmacistService.findOne(vacationResponseDTO.getVacation_id());

            if(vacationResponseDTO.isAnswer())
            {
                vac.setApproved(StatusCV.ACCEPTED);
            }
            else
            {
                vac.setApproved(StatusCV.DECLINED);
            }

            vacationPharmacistService.update(vac, vacationResponseDTO.getVacation_id());

            return new ResponseEntity<>("Uspesno odradjen odgovor na odmor!",HttpStatus.OK);

            /*
            POSALJI RAZLOG ZASTO JE ODBIJEN ILI PRIHVACEN NA EMAIL
            String mailContent = vacationResponseDTO.getReason();
            */
        }catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    private List<VacationPharmacistDTO> toVacationPharmacistDTOList(List<VacationPharmacist> vacations){
        List<VacationPharmacistDTO> vacationDTOS = new ArrayList<>();
        for (VacationPharmacist vac : vacations) {
            vacationDTOS.add(vacationPharmacistMapper.toDto(vac));
        }
        return vacationDTOS;
    }

}
