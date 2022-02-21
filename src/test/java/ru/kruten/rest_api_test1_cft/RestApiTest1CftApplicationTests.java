package ru.kruten.rest_api_test1_cft;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.kruten.rest_api_test1_cft.controller.CityController;
import ru.kruten.rest_api_test1_cft.controller.CountryController;
import ru.kruten.rest_api_test1_cft.controller.ServicePointController;
import ru.kruten.rest_api_test1_cft.controller.ServicesController;
import ru.kruten.rest_api_test1_cft.entity.City;
import ru.kruten.rest_api_test1_cft.entity.Country;
import ru.kruten.rest_api_test1_cft.entity.ServicePoint;
import ru.kruten.rest_api_test1_cft.entity.Services;
import ru.kruten.rest_api_test1_cft.service.CityService;
import ru.kruten.rest_api_test1_cft.service.CountryService;
import ru.kruten.rest_api_test1_cft.service.ServicePointService;
import ru.kruten.rest_api_test1_cft.service.ServicesService;
import java.util.ArrayList;
import java.util.List;


@WebMvcTest({
        CityController.class,
        CountryController.class,
        ServicePointController.class,
        ServicesController.class}
        )
class RestApiTest1CftApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CountryService countryService;

    @MockBean
    private CityService cityService;

    @MockBean
    private ServicePointService servicePointService;

    @MockBean
    private ServicesService servicesService;

    @Test
    public void getAllCountriesTest() throws Exception{
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Russia"));
        countries.add(new Country("USA"));
        countries.add(new Country("Japan"));
        countries.get(0).setId(1);
        countries.get(1).setId(2);
        countries.get(2).setId(3);

        Mockito.when(countryService.getAllCountries()).thenReturn(countries);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/countries"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String testResponse = mvcResult.getResponse().getContentAsString();
        String expectedResponse = objectMapper.writeValueAsString(countries);

        Assert.assertEquals(expectedResponse, testResponse);

    }

    @Test
    public void getAllCitiesTest() throws Exception{
        Country russia = new Country("Russia");
        russia.setId(1);
        Country usa = new Country("USA");
        usa.setId(2);

        List<City> cities = new ArrayList<>();
        cities.add(new City("NSK"));
        cities.add(new City("MSK"));
        cities.add(new City("NY"));
        cities.get(0).setId(1);
        cities.get(0).setCountry(russia);
        cities.get(1).setId(2);
        cities.get(1).setCountry(russia);
        cities.get(2).setId(3);
        cities.get(2).setCountry(usa);

        Mockito.when(cityService.getAllCities()).thenReturn(cities);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/cities"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String testResponse = mvcResult.getResponse().getContentAsString();
        String expectedResponse = objectMapper.writeValueAsString(cities);

        Assert.assertEquals(expectedResponse, testResponse);
    }

    @Test
    public void addNewServicePointTest() throws Exception{
        Country country = new Country("Russia");
        country.setId(1);
        City city = new City("Moscow");
        city.setCountry(country);
        city.setId(1);
        List<Services> services = new ArrayList<>();
        Services services1 = new Services();
        Services services2 = new Services();
        services1.setId(1);
        services2.setId(2);
        services1.setName("Repair");
        services2.setName("Change");
        services.add(services1);
        services.add(services2);

        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setPointName("TestName");
        servicePoint.setAddress("TestAddress");
        servicePoint.setCountry(country);
        servicePoint.setCity(city);
        servicePoint.setServicesList(services);

        String JsonRequest =
               "{\n" +
                       "    \"address\": \"TestAddress\",\n" +
                       "    \"pointName\": \"TestName\",\n" +
                       "    \"city\": {\n" +
                       "        \"id\": 1,\n" +
                       "        \"name\": \"Moscow\"\n" +
                       "    },\n" +
                       "    \"country\": {\n" +
                       "        \"id\": 1,\n" +
                       "        \"name\": \"Russia\"\n" +
                       "    },\n" +
                       "    \"servicesList\": [\n" +
                       "        {\n" +
                       "            \"id\": 1,\n" +
                       "            \"name\": \"Repair\"\n" +
                       "        }\n" +"," +
                       "        {\n" +
                       "            \"id\": 2,\n" +
                       "            \"name\": \"Change\"\n" +
                       "        }\n" +
                       "    ]\n" +
                       "}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/servicepoints")
                .content(JsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String testResponse = mvcResult.getResponse().getContentAsString();
        String expectedResponse = objectMapper.writeValueAsString(servicePoint);

        Assert.assertEquals(expectedResponse, testResponse);

    }

}
