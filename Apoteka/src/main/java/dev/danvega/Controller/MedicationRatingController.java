package dev.danvega.Controller;

import dev.danvega.Services.MedicationRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medication-ratings")
public class MedicationRatingController {

    @Autowired
    MedicationRatingService medicationRatingService = new MedicationRatingService();
}
