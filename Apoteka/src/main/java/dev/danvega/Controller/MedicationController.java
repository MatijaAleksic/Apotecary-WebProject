package dev.danvega.Controller;

import dev.danvega.Services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService = new MedicationService();
}
