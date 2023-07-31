package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.CityMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.CityRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImplementation implements CityService {

    private CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public CityDTO getCity(Long cityId) {
        City city = cityRepository.findCityById(cityId);
        return CityMapper.mapToCityDTOFromCity(city);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDTO> getAllCities() {
        List<CityDTO> cities = cityRepository.findAllCities().stream().map( (city) -> CityMapper.mapToCityDTOFromCity(city)).toList();
        return cities;
    }

    @Override
    @Transactional(readOnly = true)
    public CityDTO getCityByName(String cityName) {
        City city = cityRepository.findCityByName(cityName);
        return CityMapper.mapToCityDTOFromCity(city);
    }


}
