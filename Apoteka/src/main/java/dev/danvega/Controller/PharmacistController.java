package dev.danvega.Controller;

import dev.danvega.Services.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacist")
public class PharmacistController {

    @Autowired
    PharmacistService pharmacistService = new PharmacistService();
}
