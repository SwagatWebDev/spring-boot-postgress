package com.springbootpostgres.springbootpostgrespractise.service.impl;

import com.springbootpostgres.springbootpostgrespractise.entity.Country;
import com.springbootpostgres.springbootpostgrespractise.repository.CityRepository;
import com.springbootpostgres.springbootpostgrespractise.repository.CountryRepository;
import com.springbootpostgres.springbootpostgrespractise.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getCountryById(int id) {
        Optional<Country> country = Optional.ofNullable(countryRepository.getById(id));
        return country.get();
    }

    @Override
    public List<Country> getCountryByOrder(String prefix) {
        List<Country> countryList = countryRepository.getByCountryName(prefix);
        return countryList;
    }

    @Override
    public List<Object[]> getCountryNameAndPopulation(String countryName, Long population) {
        List<Object[]> response = countryRepository.getByCnameAndPopulationNative(countryName, population);
        return response;
    }
}
