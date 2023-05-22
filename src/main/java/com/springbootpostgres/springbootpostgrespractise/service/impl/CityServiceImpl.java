package com.springbootpostgres.springbootpostgrespractise.service.impl;

import com.springbootpostgres.springbootpostgrespractise.entity.City;
import com.springbootpostgres.springbootpostgrespractise.repository.CityRepository;
import com.springbootpostgres.springbootpostgrespractise.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cityList = cityRepository.findAll();
        return cityList;
    }

    @Override
    public City saveCityInformation(City city) {
        City response = cityRepository.save(city);
        return response;
    }

}
