package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.CityNameDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.DTO.TruckDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Track;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TrackMapper;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.TruckMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.CityRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TrackRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TruckRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TrackServiceImplementation implements TrackService {

    private TrackRepository trackRepository;
    private CityRepository cityRepository;
    private TruckRepository truckRepository;


    @Override
    public TrackDTO createTrack(List<CityNameDTO> citiesDTOName, Set<TruckDTO> truckDTOSet) {
        Set<Truck> truckSet = TruckMapper.mapToSetTruck(truckDTOSet);
        StringBuilder truckId = new StringBuilder();
        for (Truck truck: truckSet) {truckId.append(truck.getId());}
        Track track = trackRepository.createTrack(citiesDTOName.get(0).getName(), citiesDTOName.get(1).getName(), truckId.toString(), cityRepository, truckRepository);
        return TrackMapper.mapToTrackDTOFromTrack(track);
    }

}
