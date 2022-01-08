package ru.kruten.rest_api_test1_cft.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kruten.rest_api_test1_cft.entity.ServicePoint;
import ru.kruten.rest_api_test1_cft.service.CountryService;
import ru.kruten.rest_api_test1_cft.service.ServicePointService;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Service Point info", description = "Contains information about service points and CRUD methods")
public class ServicePointController {

    @Autowired
    private ServicePointService servicePointService;

    @GetMapping("/servicepoints")
    public List<ServicePoint> getAllAddresses(){
        return servicePointService.getAllAddresses();
    }

    @GetMapping("/servicepoints/{id}")
    public ServicePoint getOneAddress(@PathVariable int id){
        return servicePointService.getAddressAndPointName(id);

    }

    @PostMapping("/servicepoints")
    public ServicePoint saveNewAddress(@RequestBody ServicePoint newAddress){
        servicePointService.saveAddressAndPointName(newAddress);
        return newAddress;
    }

    @PutMapping("/servicepoints")
    public ServicePoint changeAddress(@RequestBody ServicePoint newAddress){
        servicePointService.saveAddressAndPointName(newAddress);
        return newAddress;
    }

    @DeleteMapping("/servicepoints/{id}")
    public String deleteAddress(@PathVariable int id) throws Exception {
        ServicePoint addressID = servicePointService.getAddressAndPointName(id);

        if (addressID == null)
            throw new Exception("There is no any service with this id");

        servicePointService.deleteAddressAndPointName(id);
        return "Service with " + id + " was deleted";
    }
}
