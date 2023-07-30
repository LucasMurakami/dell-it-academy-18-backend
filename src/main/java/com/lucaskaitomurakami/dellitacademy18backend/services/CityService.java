package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;

import java.util.List;

public interface CityService {

    CityDTO getCity(Long cityId);

    List<CityDTO> getAllCities();

    CityDTO getCityByName(String cityName);
}
