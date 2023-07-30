package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.CityMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.CityRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CityServiceImplementation implements CityService {

    private CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public CityDTO getCity(Long cityId) {

        City city = cityRepository.findCityById(cityId);

        return CityMapper.mapToCityDTO(city);
    }


}