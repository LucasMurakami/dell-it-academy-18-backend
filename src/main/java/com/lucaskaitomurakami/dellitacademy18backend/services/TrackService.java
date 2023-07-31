package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;

public interface TrackService {

    TrackDTO createTrack(String cityName1, String cityName2, String truckId);

}
