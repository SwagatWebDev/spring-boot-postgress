package com.springbootpostgres.springbootpostgrespractise.controller;

import com.springbootpostgres.springbootpostgrespractise.entity.City;
import com.springbootpostgres.springbootpostgrespractise.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(){
        List<City> getAllCityInfo = cityService.getAllCities();
        return getAllCityInfo;
    }

    @PostMapping(value = "/saveCities" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public City saveCityRecords(@RequestBody City city){
        City response = cityService.saveCityInformation(city);
        return response;
    }
}
