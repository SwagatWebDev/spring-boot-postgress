package com.springbootpostgres.springbootpostgrespractise.service;

import com.springbootpostgres.springbootpostgrespractise.entity.Country;

import java.util.List;

public interface CountryService {

    public Country getCountryById(int id);

    public List<Country> getCountryByOrder(String prefix);

    public List<Object[]> getCountryNameAndPopulation(String countryName, Long population);
}
