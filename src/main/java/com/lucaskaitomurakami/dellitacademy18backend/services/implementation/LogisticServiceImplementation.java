package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticConsultDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;
import com.lucaskaitomurakami.dellitacademy18backend.services.LogisticService;
import org.springframework.stereotype.Service;

@Service
public class LogisticServiceImplementation implements LogisticService {

    @Override
    public LogisticConsultDTO consultTrack(String cityName1, String cityName2, Truck truck) {
        return null;
    }
}
