package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.LogisticConsultDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Truck;

public interface LogisticService {

    public LogisticConsultDTO consultTrack(String cityName1, String cityName2, Truck truck);

}
