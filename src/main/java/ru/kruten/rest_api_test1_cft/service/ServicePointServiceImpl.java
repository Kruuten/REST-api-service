package ru.kruten.rest_api_test1_cft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kruten.rest_api_test1_cft.entity.ServicePoint;
import ru.kruten.rest_api_test1_cft.repository.ServicePointRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ServicePointServiceImpl implements ServicePointService {
    @Autowired
    private ServicePointRepository servicePointRepository;

    @Override
    public List<ServicePoint> getAllAddresses() {
        return servicePointRepository.findAll();
    }

    @Override
    public void saveAddressAndPointName(ServicePoint servicePoint) {
        servicePointRepository.save(servicePoint);
    }

    @Override
    public ServicePoint getAddressAndPointName(int id) {
        ServicePoint addressAndPointName = null;
        Optional<ServicePoint> optional = servicePointRepository.findById(id);
        if (optional.isPresent())
            addressAndPointName = optional.get();
        return addressAndPointName;
    }

    @Override
    public void deleteAddressAndPointName(int id) {
        servicePointRepository.deleteById(id);
    }
}
