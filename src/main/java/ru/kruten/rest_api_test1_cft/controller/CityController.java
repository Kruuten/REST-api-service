package ru.kruten.rest_api_test1_cft.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kruten.rest_api_test1_cft.entity.City;
import ru.kruten.rest_api_test1_cft.service.CityService;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name="Cities", description = "Get information about all cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCountries(){
        return cityService.getAllCities();
    }
}
