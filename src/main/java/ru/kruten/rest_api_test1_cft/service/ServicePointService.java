package ru.kruten.rest_api_test1_cft.service;

import ru.kruten.rest_api_test1_cft.entity.ServicePoint;

import java.util.List;


public interface ServicePointService {
    public List<ServicePoint> getAllAddresses();

    public void saveAddressAndPointName(ServicePoint addressAndPointName);

    public ServicePoint getAddressAndPointName(int id);

    public void deleteAddressAndPointName(int id);
}
