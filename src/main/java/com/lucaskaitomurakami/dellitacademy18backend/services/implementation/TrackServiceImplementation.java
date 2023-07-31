package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TrackMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.CityRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TrackRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TruckRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TrackServiceImplementation implements TrackService {

    private TrackRepository trackRepository;
    private CityRepository cityRepository;
    private TruckRepository truckRepository;


    @Override
    public TrackDTO createTrack(String cityName1, String cityName2, String truckId) {
        Truck truck = truckRepository.findTruckById(Long.valueOf(truckId));
        Track track = trackRepository.createTrack(cityName1, cityName2, truck , cityRepository, truckRepository);
        return TrackMapper.mapToLogisticDTOfromLogistic(track);
    }

}
