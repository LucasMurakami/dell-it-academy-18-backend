package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.entities.City;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface TrackRepository extends JpaRepository<Track, Long> {

    default Track createTrack(String cityName1, String cityName2, String truckId, CityRepository cityRepository, TruckRepository truckRepository) {

        City city1, city2;
        List<City> citiesName = new ArrayList<>();
        city1 = cityRepository.findCityByName(cityName1);
        city2 = cityRepository.findCityByName(cityName2);
        citiesName.add(city1);
        citiesName.add(city2);

        Truck truck = truckRepository.findTruckById(Long.valueOf(truckId));

        int distance = cityRepository.findDistanceBetweenCities(city1, city2);
        double totalPrice = truckRepository.totalPriceByTrack(truck, distance);

        Track track = new Track();
        Set<Truck> truckSet = new HashSet<>();
        truckSet.add(truck);

        track.setCitiesName(citiesName);
        track.setTrucks(truckSet);
        track.setPriceByTrack(totalPrice);
        track.setTrackDistance(distance);


        return track;
    }

}
