package ru.kruten.rest_api_test1_cft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kruten.rest_api_test1_cft.entity.Services;
import ru.kruten.rest_api_test1_cft.repository.ServicesRepository;
import java.util.List;


@Service
public class ServicesServiceImpl implements ServicesService{
    @Autowired
    ServicesRepository servicesRepository;

    @Override
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

}
