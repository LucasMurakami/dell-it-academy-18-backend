package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import org.springframework.beans.BeanUtils;

public class CityMapper {

    public static CityDTO mapToCityDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        BeanUtils.copyProperties(city, cityDTO);
        return cityDTO;
    }

    public static City mapToCity(CityDTO cityDTO) {
        City city = new City();
        BeanUtils.copyProperties(cityDTO, city);
        return city;
    }
}
