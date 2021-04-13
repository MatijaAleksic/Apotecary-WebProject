package dev.danvega.Controller;

import dev.danvega.Services.PharmacistRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacist-ratings")
public class PharmacistRatingController {

    @Autowired
    PharmacistRatingService pharmacistRatingService = new PharmacistRatingService();
}
