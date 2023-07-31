package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityNameDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;

import java.util.List;
import java.util.Set;

public interface TrackService {

    TrackDTO createTrack(List<CityNameDTO> citiesName, Set<TruckDTO> truckSet);

}
