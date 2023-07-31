package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticTrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.LogisticServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/logistic")
@AllArgsConstructor
public class LogisticController {

    private LogisticServiceImplementation logisticServiceImplementation;

    // Build Add Create Track (Logistic) REST API
    @PostMapping
    public ResponseEntity<LogisticTrackDTO> createTrack(@RequestBody LogisticTrackDTO logisticTrackDTO) {
        LogisticTrackDTO savedTrack = logisticServiceImplementation.createTrack(logisticTrackDTO.getCityName1(), logisticTrackDTO.getCityName2(), logisticTrackDTO.getTruckId());
        return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
    }
}
