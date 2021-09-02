package com.sahil.movieBookingSystem.services.impl;

import com.sahil.movieBookingSystem.dao.CityDao;
import com.sahil.movieBookingSystem.entities.City;
import com.sahil.movieBookingSystem.exceptions.CityDetailsNotFoundException;
import com.sahil.movieBookingSystem.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    public CityDao cityDao;

    @Override
    public City acceptCityDetails(City city) {
        return cityDao.save(city);
    }

    @Override
    public List<City> acceptMultipleCityDetails(List<City> cities) {
        for(int i = 0; i < cities.size(); i++){
            cities.set(i,acceptCityDetails(cities.get(i)));
        }
        return cities;
    }

    @Override
    public City updateCityDetails(int id, City city) throws CityDetailsNotFoundException {
        City savedCity = getCityDetails(id);
        savedCity.setCityName(city.getCityName());
        acceptCityDetails(savedCity);
        return savedCity;
    }

    @Override
    public City getCityDetails(int id) throws CityDetailsNotFoundException {
        return cityDao.findById(id).orElseThrow(()-> new CityDetailsNotFoundException("City not found of id: " + id));
    }

    @Override
    public City getCityDetailsByCityName(String cityName) throws CityDetailsNotFoundException {
        City savedCity = cityDao.findByCityName(cityName);
        if(savedCity == null){
            throw new CityDetailsNotFoundException("City not found by cityName: " + cityName);
        }
        return savedCity;
    }

    @Override
    public boolean deleteCity(int id) throws CityDetailsNotFoundException {
        City savedCity = getCityDetails(id);
        cityDao.delete(savedCity);
        return true;
    }

    @Override
    public List<City> getAllCityDetails() {
        return cityDao.findAll();
    }
}
