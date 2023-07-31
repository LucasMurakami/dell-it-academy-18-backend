package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;

import java.util.Set;

public interface TrackService {

    TrackDTO createTrack(String cityName1, String cityName2, Set<TruckDTO> truckSet);

}
