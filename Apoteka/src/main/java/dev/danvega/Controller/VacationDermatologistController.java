package dev.danvega.Controller;

import dev.danvega.DTO.ApotecaryIDDTO;
import dev.danvega.DTO.VacationDermatologistDTO;
import dev.danvega.DTO.VacationPharmacistDTO;
import dev.danvega.DTO.VacationResponseDTO;
import dev.danvega.Mapper.VacationDermatologistMapper;
import dev.danvega.Model.Enums.StatusCV;
import dev.danvega.Model.VacationDermatologist;
import dev.danvega.Model.VacationPharmacist;
import dev.danvega.Services.VacationDermatologistService;
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
@RequestMapping("/api/dermatologist-vacation")
public class VacationDermatologistController {

    @Autowired
    VacationDermatologistService vacationDermatologistService  = new VacationDermatologistService();

    private final VacationDermatologistMapper vacationDermatologistMapper = new VacationDermatologistMapper();


    @Transactional
    @PostMapping("/get-all-admin")
    public ResponseEntity<List<VacationDermatologistDTO>> get_all_admin(@RequestBody ApotecaryIDDTO apotecaryIDDTO) {

        List<VacationDermatologist> vacations = vacationDermatologistService.findAll();
        if (vacations == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<VacationDermatologist> vacationsAdmin = new ArrayList<>();

            for (VacationDermatologist vac : vacations) {

                if (vac.getDermatologist().getApotecary().getId().equals(apotecaryIDDTO.getId())) {
                    vacationsAdmin.add(vac);
                }
            }
            return new ResponseEntity<>(toVacationDermatologistDTOList(vacationsAdmin), HttpStatus.OK);
        }
    }

    @PostMapping("/vacation-response")
    public ResponseEntity<String> response_to_vacation(@RequestBody VacationResponseDTO vacationResponseDTO) {
        try{
            VacationDermatologist vac = vacationDermatologistService.findOne(vacationResponseDTO.getVacation_id());

            if(vacationResponseDTO.isAnswer())
            {
                vac.setApproved(StatusCV.ACCEPTED);
            }
            else
            {
                vac.setApproved(StatusCV.DECLINED);
            }

            vacationDermatologistService.update(vac, vacationResponseDTO.getVacation_id());

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


    private List<VacationDermatologistDTO> toVacationDermatologistDTOList(List<VacationDermatologist> vacations){
        List<VacationDermatologistDTO> vacationDTOS = new ArrayList<>();
        for (VacationDermatologist vac : vacations) {
            vacationDTOS.add(vacationDermatologistMapper.toDto(vac));
        }
        return vacationDTOS;
    }
}
