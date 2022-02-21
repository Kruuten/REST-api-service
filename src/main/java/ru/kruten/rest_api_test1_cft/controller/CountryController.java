package ru.kruten.rest_api_test1_cft.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kruten.rest_api_test1_cft.entity.Country;
import ru.kruten.rest_api_test1_cft.service.CountryService;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Countries", description = "Get information about all countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }
}
