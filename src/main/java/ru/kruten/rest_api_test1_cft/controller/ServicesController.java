package ru.kruten.rest_api_test1_cft.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kruten.rest_api_test1_cft.entity.Services;
import ru.kruten.rest_api_test1_cft.service.ServicesService;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "services", description = "Get information about all services company has")
public class ServicesController {
    @Autowired
    private ServicesService service;

    @GetMapping("/services")
    public List<Services> getAllServices(){
        List<Services> services = service.getAllServices();
        return services;
    }
}
