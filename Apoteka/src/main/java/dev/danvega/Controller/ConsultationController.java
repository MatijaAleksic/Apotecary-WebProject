package dev.danvega.Controller;

import dev.danvega.Services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    ConsultationService consultationService = new ConsultationService();
}
