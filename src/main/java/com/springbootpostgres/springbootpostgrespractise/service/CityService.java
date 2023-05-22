package com.springbootpostgres.springbootpostgrespractise.service;

import com.springbootpostgres.springbootpostgrespractise.entity.City;

import java.util.List;

public interface CityService {

    public List<City> getAllCities();

    public City saveCityInformation(City city);
}
