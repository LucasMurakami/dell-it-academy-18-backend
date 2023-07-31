package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticConsultDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Logistic;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogisticRepository extends JpaRepository<Logistic, Long> {


    default LogisticConsultDTO consultTrack(String cityName1, String cityName2, Truck truck, CityRepository cityRepository) {

        City city1, city2;
        city1 = cityRepository.findCityByName(cityName1);
        city2 = cityRepository.findCityByName(cityName2);

        int distance = cityRepository.findDistanceBetweenCities(city1, city2);

        return null;
    }

}