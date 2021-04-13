package dev.danvega.Controller;

import dev.danvega.Services.MedicationReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medication-reservations")
public class MedicationReservationController {

    @Autowired
    MedicationReservationService medicationReservationService = new MedicationReservationService();
}
