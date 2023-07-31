package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.AdvancedTrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.TrackServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/logistic")
@AllArgsConstructor
public class TrackController {

    private TrackServiceImplementation trackServiceImplementation;

    // Build Create Track (Logistic) REST API
    @PostMapping
    public ResponseEntity<TrackDTO> createTrack(@RequestBody TrackDTO trackDTO) {
        TrackDTO savedTrack = trackServiceImplementation.createTrack(trackDTO.getCitiesName(), trackDTO.getTrucks());
        return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);
    }

    // Build Create List<AdvancedTrackDTO> REST API
    @PostMapping("/advanced")
    public ResponseEntity<List<AdvancedTrackDTO>> createAdvancedTrackDTOList(@RequestBody AdvancedTrackDTO advancedTrackDTO) {
        List<AdvancedTrackDTO> savedAdvancedTrackList = trackServiceImplementation.createAdvancedTrackDTOList(advancedTrackDTO.getCitiesName(), advancedTrackDTO.getProductDTOS());
        return new ResponseEntity<>(savedAdvancedTrackList, HttpStatus.CREATED);
    }
}
