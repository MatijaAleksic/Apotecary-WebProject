package dev.danvega.Controller;

import dev.danvega.Services.MedicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medication-info")
public class MedicationInfoController {

    @Autowired
    MedicationInfoService medicationInfoService = new MedicationInfoService();
}
