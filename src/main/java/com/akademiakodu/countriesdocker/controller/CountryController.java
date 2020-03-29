package com.akademiakodu.countriesdocker.controller;

import com.akademiakodu.countriesdocker.model.Country;
import com.akademiakodu.countriesdocker.model.CountryAPI;
import com.akademiakodu.countriesdocker.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {


    @Autowired
    CountryService countryService;

    @GetMapping("/{code}")
    public CountryAPI getCountry(@PathVariable String code) {

        Country country = countryService.getCountry(code);

        List<String> languages = new ArrayList<>();
        languages.add("PL");

        return new CountryAPI(country.getName(),
                country.getContinent(),
                country.getPopulation(),
                country.getLifeExpectation(),
                languages
                );
    }

}
