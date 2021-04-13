package dev.danvega.Controller;

import dev.danvega.Services.AlergiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alergies")
public class AlergiesController {

    @Autowired
    AlergiesService alergiesService = new AlergiesService();
}
