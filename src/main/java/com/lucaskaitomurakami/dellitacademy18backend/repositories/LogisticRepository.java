package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Logistic;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogisticRepository extends JpaRepository<Logistic, Long> {

    default Logistic createTrack(String cityName1, String cityName2, Truck truck, CityRepository cityRepository, TruckRepository truckRepository) {

        City city1, city2;
        city1 = cityRepository.findCityByName(cityName1);
        city2 = cityRepository.findCityByName(cityName2);

        int distance = cityRepository.findDistanceBetweenCities(city1, city2);
        double totalPrice = truckRepository.totalPriceByTrack(truck, distance);

        Logistic logistic = new Logistic();
        logistic.setCityName1(cityName1);
        logistic.setCityName2(cityName2);
        logistic.setTruckId(String.valueOf(truck.getId()));
        logistic.setTruckType(truck.getType());
        logistic.setPriceByTrack(totalPrice);
        logistic.setTrackDistance(distance);
        return logistic;
    }

}
