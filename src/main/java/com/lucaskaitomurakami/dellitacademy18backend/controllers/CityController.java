package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.CityServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private CityServiceImplementation cityService;

    // Build Get City REST API
    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long cityId) {
        CityDTO cityDTO = cityService.getCity(cityId);
        return ResponseEntity.ok(cityDTO);
    }

    // Build Get All Cities REST API
    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> citiesDTO = cityService.getAllCities();
        return ResponseEntity.ok(citiesDTO);
    }

    // Build Get City By Name REST API
    @GetMapping("/name")
    public ResponseEntity<CityDTO> getCityByName(@RequestParam(value = "name")String cityName) {
        CityDTO cityDTO = cityService.getCityByName(cityName);
        return ResponseEntity.ok(cityDTO);
    }

}
