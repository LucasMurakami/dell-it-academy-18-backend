package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TruckMapper;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.TrackServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/logistic")
@AllArgsConstructor
public class TrackController {

    private TrackServiceImplementation logisticServiceImplementation;

    // Build Add Create Track (Logistic) REST API
    @PostMapping
    public ResponseEntity<TrackDTO> createTrack(@RequestBody TrackDTO trackDTO) {
        TrackDTO savedTrack = logisticServiceImplementation.createTrack(trackDTO.getCitiesName(), trackDTO.getTrucks());
        return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
    }
}
