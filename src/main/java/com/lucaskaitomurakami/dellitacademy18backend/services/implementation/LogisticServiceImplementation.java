package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticTrackDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Logistic;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.LogisticMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.CityRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.LogisticRepository;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.TruckRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.LogisticService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogisticServiceImplementation implements LogisticService {

    private LogisticRepository logisticRepository;
    private CityRepository cityRepository;
    private TruckRepository truckRepository;


    @Override
    public LogisticTrackDTO createTrack(String cityName1, String cityName2, String truckId) {
        Truck truck = truckRepository.findTruckById(Long.valueOf(truckId));
        Logistic logistic = logisticRepository.createTrack(cityName1, cityName2, truck , cityRepository, truckRepository);
        return LogisticMapper.mapToLogisticTrackDTOFromLogistic(logistic);
    }

}
