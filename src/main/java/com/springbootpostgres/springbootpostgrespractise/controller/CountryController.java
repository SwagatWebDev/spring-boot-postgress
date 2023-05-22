package com.springbootpostgres.springbootpostgrespractise.controller;

import com.springbootpostgres.springbootpostgrespractise.entity.City;
import com.springbootpostgres.springbootpostgrespractise.entity.Country;
import com.springbootpostgres.springbootpostgrespractise.service.CountryService;
import com.springbootpostgres.springbootpostgrespractise.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping(value = "/country/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Country getCountry(@PathVariable("id") int id){
        Country getCountry = countryService.getCountryById(id);
        return getCountry;
    }

    @GetMapping(value = "/countryorder", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getCountryOrder(@RequestParam String prefix){
        List<Country> getCountryOrder = countryService.getCountryByOrder(prefix);
        return getCountryOrder;
    }

    @GetMapping(value = "/countryandpopulation", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object[]> getCountryAndPopulation(@RequestParam String countryName, @RequestParam Long population){
        List<Object[]> getCountryAndPopulationData = countryService.getCountryNameAndPopulation(countryName, population);
        return getCountryAndPopulationData;
    }

}
