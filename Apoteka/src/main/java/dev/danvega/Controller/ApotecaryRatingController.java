package dev.danvega.Controller;

import dev.danvega.Services.ApotecaryRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apotecary-ratings")
public class ApotecaryRatingController {

    @Autowired
    ApotecaryRatingService apotecaryRatingService = new ApotecaryRatingService();
}
