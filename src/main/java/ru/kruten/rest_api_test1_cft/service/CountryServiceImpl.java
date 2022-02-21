package ru.kruten.rest_api_test1_cft.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kruten.rest_api_test1_cft.entity.Country;
import ru.kruten.rest_api_test1_cft.repository.CountryRepository;
import java.util.List;


@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
