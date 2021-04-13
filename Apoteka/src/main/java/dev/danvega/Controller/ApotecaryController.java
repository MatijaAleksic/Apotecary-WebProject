package dev.danvega.Controller;

import dev.danvega.Services.ApotecaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apotecary")
public class ApotecaryController {

    @Autowired
    ApotecaryService alergiesService = new ApotecaryService();
}
