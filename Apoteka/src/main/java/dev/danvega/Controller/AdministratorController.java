package dev.danvega.Controller;

import dev.danvega.Services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService = new AdministratorService();
}
