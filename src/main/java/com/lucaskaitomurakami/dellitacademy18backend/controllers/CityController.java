package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.CityServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private CityServiceImplementation cityService;

    // Build Get City REST API
    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long cityId) throws FileNotFoundException {
        CityDTO cityDTO = cityService.getCity(cityId);
        return ResponseEntity.ok(cityDTO);
    }

    // Build Get All Cities REST API
    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }
}
