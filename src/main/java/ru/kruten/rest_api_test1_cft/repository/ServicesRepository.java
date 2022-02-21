package ru.kruten.rest_api_test1_cft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kruten.rest_api_test1_cft.entity.Services;


public interface ServicesRepository extends JpaRepository<Services, Integer> {
}
