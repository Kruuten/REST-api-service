package ru.kruten.rest_api_test1_cft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kruten.rest_api_test1_cft.entity.City;
import ru.kruten.rest_api_test1_cft.repository.CityRepository;
import java.util.List;


@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
