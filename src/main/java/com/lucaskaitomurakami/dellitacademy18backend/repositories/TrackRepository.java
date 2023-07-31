package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {

    default Track createTrack(String cityName1, String cityName2, Truck truck, CityRepository cityRepository, TruckRepository truckRepository) {

        City city1, city2;
        city1 = cityRepository.findCityByName(cityName1);
        city2 = cityRepository.findCityByName(cityName2);

        int distance = cityRepository.findDistanceBetweenCities(city1, city2);
        double totalPrice = truckRepository.totalPriceByTrack(truck, distance);

        Track track = new Track();
        track.setCityName1(cityName1);
        track.setCityName2(cityName2);
        track.setTruckId(String.valueOf(truck.getId()));
        track.setTruckType(truck.getType());
        track.setPriceByTrack(totalPrice);
        track.setTrackDistance(distance);
        return track;
    }

}
