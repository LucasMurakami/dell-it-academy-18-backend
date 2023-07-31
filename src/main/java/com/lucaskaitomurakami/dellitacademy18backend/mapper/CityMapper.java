package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityNameDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CityMapper {

    public static CityDTO mapToCityDTOFromCity(City city) {
        CityDTO cityDTO = new CityDTO();
        BeanUtils.copyProperties(city, cityDTO);
        return cityDTO;
    }

    public static City mapToCity(CityDTO cityDTO) {
        City city = new City();
        BeanUtils.copyProperties(cityDTO, city);
        return city;
    }

    public static List<CityDTO> mapToListCityDTO(List<City> cityList) {
        return cityList.stream().map( (city) -> mapToCityDTOFromCity(city)).toList();
    }

    public static CityNameDTO mapToCityNameDTOFromCity(City city) {
        CityNameDTO cityNameDTO = new CityNameDTO();
        BeanUtils.copyProperties(city, cityNameDTO);
        return cityNameDTO;
    }

    public static List<CityNameDTO> mapToListCityNameDTO(List<City> cityList) {
        return cityList.stream().map( (city) -> mapToCityNameDTOFromCity(city) ).toList();
    }

    public static CityDTO mapToCityDTOFromCityNameDTO(CityNameDTO cityNameDTO) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(cityNameDTO.getName());
        return cityDTO;
    }

    public static List<String> mapToStringListFromCityNameDTO(List<CityNameDTO> cityNameDTOList) {
        List<String> result = new ArrayList<>();
        for (CityNameDTO cityName:cityNameDTOList) {result.add(cityName.getName());}
        return result;
    }

}
