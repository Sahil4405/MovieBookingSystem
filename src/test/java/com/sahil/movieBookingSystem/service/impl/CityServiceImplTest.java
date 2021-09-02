package com.sahil.movieBookingSystem.service.impl;

import com.sahil.movieBookingSystem.dao.CityDao;
import com.sahil.movieBookingSystem.entities.City;
import com.sahil.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.impl.CityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CityServiceImplTest {

    /**
     * CityServiceImpl -> cityDao
     *
     * Unit Test:
     * 1. Create mock of cityDao
     * 2. Create CityServiceImpl using mocked cityDao.
     * 3. Private the functionality of CityDao
     */

    /**
     * Create mock of CityDao
     */
    @Mock
    private CityDao cityDao;

    /**
     * Create CityServiceImpl usinf mock cityDao
     */
    @InjectMocks
    private CityServiceImpl cityService;

    /**
     * Provide the functionality for cityDao
     */
    @BeforeEach
    public void addFunctionalityToMockedCityDao(){
        Mockito.when(cityDao.save(new City("Bangalore"))).thenReturn(new City(1,"Bangalore"));

        //Mock function to get
        Mockito.when(cityDao.findById(2)).thenReturn(Optional.of(new City(2,"Mumbai")));

        Mockito.when(cityDao.save(new City(2,"MumbaiNew"))).thenReturn(new City(2,"MumbaiNew"));
    }


    /**
     * Test acceptCityDetails
     */
    @Test
    public void testAcceptCityDetails(){
        /**
         * Test if CityServiceImpl is able to save city details
         */
        City city = new City("Bangalore");

        City savedCity = cityService.acceptCityDetails(city);
        System.out.println(savedCity);

        /**
         * Assertions -- expected is matching with the actual or not?
         */
        Assertions.assertNotNull(savedCity);
        Assertions.assertEquals(1,savedCity.getCityId());

    }


    /**
     * acceptMultipleCityDetails
     */


    /**
     * updateCityDetails
     */
    @Test
    public void updateCityDetails() throws CityDetailsNotFoundException {
        City city = new City("MumbaiNew");
        City updatedCity = cityService.updateCityDetails(2,city);

        Assertions.assertNotNull(updatedCity);
        Assertions.assertEquals(2,updatedCity.getCityId());
    }

    /**
     * getCityDetails
     */

    /**
     * getCityDetailsByCityName
     */

    /**
     * deleteCity
     */

    /**
     * getAllCityDetails
     */
}
