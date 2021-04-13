package dev.danvega.Controller;

import dev.danvega.Services.MedicationSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medication-specifications")
public class MedicationSpecificationController {

    @Autowired
    MedicationSpecificationService medicationSpecificationService = new MedicationSpecificationService();
}
