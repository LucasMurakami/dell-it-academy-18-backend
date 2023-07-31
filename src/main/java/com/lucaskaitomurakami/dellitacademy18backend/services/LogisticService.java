package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticTrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;

public interface LogisticService {

    LogisticTrackDTO createTrack(String cityName1, String cityName2, String truckId);

}
