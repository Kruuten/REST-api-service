package ru.kruten.rest_api_test1_cft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kruten.rest_api_test1_cft.entity.Country;


public interface CountryRepository extends JpaRepository<Country, Integer> {
}
