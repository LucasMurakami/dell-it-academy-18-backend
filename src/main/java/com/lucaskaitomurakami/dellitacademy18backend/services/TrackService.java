package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.*;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;

import java.util.List;

public interface TrackService {

    TrackDTO createTrack(List<CityNameDTO> citiesDTOName, List<TruckDTO> truckDTOList);

    List<AdvancedTrackDTO> createAdvancedTrackDTOList(List<CityNameDTO> citiesDTOName, List<ProductDTO>products);
}
