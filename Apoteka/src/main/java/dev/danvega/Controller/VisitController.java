package dev.danvega.Controller;

import dev.danvega.Services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visit")
public class VisitController {

    @Autowired
    VisitService visitService = new VisitService();
}
