package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.TruckServiceImplementation;
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
@RequestMapping("/api/trucks")
public class TruckController {

    private TruckServiceImplementation truckService;

    // Build Get City REST API
    @GetMapping("/{id}")
    public ResponseEntity<TruckDTO> getCityById(@PathVariable("id") Long cityId) {
        TruckDTO truckDTO = truckService.getTruck(cityId);
        return ResponseEntity.ok(truckDTO);
    }

    // Build Get All Cities REST API
    @GetMapping
    public ResponseEntity<List<TruckDTO>> getAllTrucks() {
        List<TruckDTO> truckDTOS = truckService.getAllTrucks();
        return ResponseEntity.ok(truckDTOS);
    }
}
